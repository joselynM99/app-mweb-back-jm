package com.mweb.negocios.rest;

import com.mweb.negocios.db.Negocio;
import com.mweb.negocios.db.Rol;
import com.mweb.negocios.db.Usuario;
import com.mweb.negocios.dtos.NegocioDTO;
import com.mweb.negocios.dtos.RolDTO;
import com.mweb.negocios.dtos.UsuarioDTO;
import com.mweb.negocios.repo.NegocioRepository;
import com.mweb.negocios.repo.RolRepository;
import com.mweb.negocios.repo.UsuarioRepository;
import com.mweb.negocios.service.KeycloakService;
import io.quarkus.oidc.AccessTokenCredential;
import io.quarkus.panache.common.Parameters;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/negocios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class NegocioRest {


    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    NegocioRepository negocioRepository;

    @Inject
    RolRepository rolRepository;

    @Inject
    KeycloakService keycloakService;

    @Inject
    AccessTokenCredential accessTokenCredential;

    // Usuarios
    @GET
    @Path("/roles")
    @Authenticated
    public Response listarRoles() {
        try {
            List<Rol> roles = rolRepository.listAll();
            if (roles.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron roles").build();
            }
            List<RolDTO> rolesDTO = roles.stream().map(RolDTO::from).collect(Collectors.toList());
            return Response.ok(rolesDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al listar los roles")
                    .build();
        }
    }

    @POST
    @Path("/usuarios")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response registrarUsuario(UsuarioDTO usuarioDTO) {
        try {
            // Check if the negocio exists
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(usuarioDTO.getNegocioId());
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }

            Optional<Rol> rolOpt = rolRepository.find("nombre", usuarioDTO.getRol()).firstResultOptional();
            if (rolOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Rol no encontrado").build();
            }

            String token = accessTokenCredential.getToken();
            String keycloakUserId = keycloakService.createUser(usuarioDTO.getNombreUsuario(), usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getCorreo(), usuarioDTO.getPassword());
            keycloakService.assignRole(keycloakUserId, rolOpt.get().getNombre());

            Usuario usuario = UsuarioDTO.from(usuarioDTO);
            usuario.setKeycloakId(keycloakUserId);
            usuario.setNegocio(negocioOpt.get());
            usuario.setRol(rolOpt.get());
            usuario.setActivo(true);
            usuarioRepository.persist(usuario);

            return Response.ok("Usuario registrado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el usuario")
                    .build();
        }
    }

    @PUT
    @Path("/usuarios/{keycloakId}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarUsuario(@PathParam("keycloakId") String userId, UsuarioDTO usuarioDTO) {
        try {
            // Check if the user exists in the local database by Keycloak ID
            Optional<Usuario> usuarioOpt = usuarioRepository.find("keycloakId", userId).firstResultOptional();
            if (usuarioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }

            Optional<Rol> rolOpt = rolRepository.find("nombre", usuarioDTO.getRol()).firstResultOptional();
            if (rolOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Rol no encontrado").build();
            }


            keycloakService.updateUser(userId, usuarioDTO.getNombreUsuario(), usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getCorreo(), usuarioDTO.getPassword(), usuarioDTO.isActivo());
            keycloakService.assignRole(userId, rolOpt.get().getNombre());

            Usuario usuario = usuarioOpt.get();
            usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
            usuario.setCorreo(usuarioDTO.getCorreo());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setActivo(usuarioDTO.isActivo());
            usuario.setTelefono(usuarioDTO.getTelefono());
            usuario.setIdentificacion(usuarioDTO.getIdentificacion());
            usuario.setRol(rolOpt.get());

            return Response.ok("Usuario actualizado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el usuario")
                    .build();
        }
    }

    @GET
    @Path("/{negocioId}/usuarios")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response listarUsuariosPorNegocio(@PathParam("negocioId") Integer negocioId) {
        try {
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(negocioId);
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }

            List<Usuario> usuarios = usuarioRepository.find("negocio.id = ?1 and activo = true", negocioId).list();
            if (usuarios.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron usuarios activos para el negocio especificado").build();
            }

            List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::from).collect(Collectors.toList());
            return Response.ok(usuariosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al listar los usuarios")
                    .build();
        }
    }

    @GET
    @Path("/usuarios/buscarPorNegocio")
    @Authenticated
    public Response buscarUsuarioPorNombreUsuarioNegocio(@QueryParam("username") String username, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Usuario> usuarioOpt = usuarioRepository.find("nombreUsuario = ?1 and negocio.id = ?2 and activo = true", username, idNegocio).firstResultOptional();
            if (usuarioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontró un usuario activo con el nombre de usuario e id de negocio especificados").build();
            }

            UsuarioDTO usuarioDTO = UsuarioDTO.from(usuarioOpt.get());
            return Response.ok(usuarioDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el usuario")
                    .build();
        }
    }

    @GET
    @Path("/usuarios/buscar")
    @Authenticated
    public Response buscarUsuarioPorNombreUsuario(@QueryParam("username") String username) {
        try {
            Optional<Usuario> usuarioOpt = usuarioRepository.find("nombreUsuario = ?1 and activo = true", username).firstResultOptional();
            if (usuarioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontró un usuario activo con el nombre de usuario especificado").build();
            }

            UsuarioDTO usuarioDTO = UsuarioDTO.from(usuarioOpt.get());
            return Response.ok(usuarioDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el usuario")
                    .build();
        }
    }

    @DELETE
    @Path("/usuarios/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response eliminarUsuario(@PathParam("id") String userId, @QueryParam("idNegocio") Integer idNegocio) {
        try {
            Optional<Usuario> usuarioOpt = usuarioRepository.find("keycloakId = ?1 and negocio.id = ?2", userId, idNegocio).firstResultOptional();
            if (usuarioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }

            keycloakService.deleteUser(userId);
            Usuario usuario = usuarioOpt.get();
            usuario.setActivo(false);
            //usuario.setKeycloakId(null);
            return Response.ok("Usuario eliminado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al eliminar el usuario")
                    .build();
        }
    }


    //Negocio
    @POST
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response registrarNegocio(NegocioDTO negocioDTO) {
        try {
            Optional<Negocio> existingNegocio = negocioRepository.find("nombreComercial = ?1 or razonSocial = ?2 or ruc = ?3 and activo = true", negocioDTO.getNombreComercial(), negocioDTO.getRazonSocial(), negocioDTO.getRuc()).firstResultOptional();
            if (existingNegocio.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un negocio activo con el mismo nombre comercial, razón social o RUC")
                        .build();
            } else {
                Negocio negocio = NegocioDTO.from(negocioDTO);
                negocio.setActivo(true);
                negocioRepository.persist(negocio);
                return Response.ok("Negocio registrado exitosamente").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al registrar el negocio")
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    @Transactional
    public Response actualizarNegocio(@PathParam("id") Integer id, NegocioDTO negocioDTO) {

        try {
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(id);
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }

            System.out.println("Actualizando negocio2: " + negocioDTO.toString());
            Optional<Negocio> existingNegocioOPt = negocioRepository.find("id != ?1 and (nombreComercial = ?2 or razonSocial = ?3 or ruc = ?4) and activo = true", id, negocioDTO.getNombreComercial(), negocioDTO.getRazonSocial(), negocioDTO.getRuc()).firstResultOptional();
            if (existingNegocioOPt.isPresent()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Ya existe un negocio activo con el mismo nombre comercial, razón social o RUC")
                        .build();
            }
            Negocio existingNegocio = negocioOpt.get();
            existingNegocio.setNombreComercial(negocioDTO.getNombreComercial());
            existingNegocio.setDireccion(negocioDTO.getDireccion());
            existingNegocio.setTelefono(negocioDTO.getTelefono());
            existingNegocio.setRazonSocial(negocioDTO.getRazonSocial());
            existingNegocio.setRuc(negocioDTO.getRuc());
            return Response.ok("Negocio actualizado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al actualizar el negocio")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"ADMINISTRADOR", "PROPIETARIO"})
    public Response obtenerNegocioPorId(@PathParam("id") Integer id) {
        try {
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(id);
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }
            NegocioDTO negocioDTO = NegocioDTO.from(negocioOpt.get());
            return Response.ok(negocioDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar el negocio")
                    .build();
        }
    }

    @GET
    @Path("/buscar")
    @RolesAllowed("ADMINISTRADOR")
    public Response buscarPorNombreComercialORazonSocial(@QueryParam("query") String query) {
        try {
            String consulta = "(LOWER(nombreComercial) LIKE CONCAT('%', :query, '%') OR LOWER(razonSocial) LIKE CONCAT('%', :query, '%')) AND activo = true";

            List<Negocio> negocios = negocioRepository.list(consulta, Parameters.with("query", query.toLowerCase()).map());

            if (negocios.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron negocios con el término especificado")
                        .build();
            }

            List<NegocioDTO> negociosDTO = negocios.stream().map(NegocioDTO::from).collect(Collectors.toList());
            return Response.ok(negociosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar los negocios")
                    .build();
        }
    }

    @GET
    @Path("/buscarPorRuc")
    @RolesAllowed("ADMINISTRADOR")
    public Response buscarPorRuc(@QueryParam("ruc") String ruc) {
        try {
            List<Negocio> negocios = negocioRepository.find("ruc = ?1 and activo = true", ruc).list();

            if (negocios.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No se encontraron negocios con el RUC especificado")
                        .build();
            }

            List<NegocioDTO> negociosDTO = negocios.stream().map(NegocioDTO::from).collect(Collectors.toList());
            return Response.ok(negociosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al buscar los negocios")
                    .build();
        }
    }

    @GET
    @RolesAllowed("ADMINISTRADOR")
    public Response listaNegocios() {
        try {
            List<Negocio> negocios = negocioRepository.listAll();
            if (negocios.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron negocios").build();
            }
            List<NegocioDTO> negociosDTO = negocios.stream().map(NegocioDTO::from).collect(Collectors.toList());
            return Response.ok(negociosDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al obtener los negocios")
                    .build();
        }
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response desactivarNegocio(@PathParam("id") Integer id) {
        try {
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(id);
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }
            Negocio negocio = negocioOpt.get();
            negocio.setActivo(false);
            return Response.ok("Negocio desactivado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el negocio")
                    .build();
        }
    }

    @PATCH
    @Path("/activar/{id}")
    @RolesAllowed("ADMINISTRADOR")
    @Transactional
    public Response activarNegocio(@PathParam("id") Integer id) {
        try {
            Optional<Negocio> negocioOpt = negocioRepository.findByIdOptional(id);
            if (negocioOpt.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("Negocio no encontrado").build();
            }
            Negocio negocio = negocioOpt.get();
            negocio.setActivo(true);
            return Response.ok("Negocio desactivado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ha ocurrido un error al desactivar el negocio")
                    .build();
        }
    }
}