package com.mweb.inventario.dtos;

import com.mweb.inventario.db.Proveedor;
import com.mweb.inventario.db.enums.TipoIdentificacion;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ProveedorDTO {

    private Integer id;
    private String tipoIdentificacion;
    private String identificacion;
    private String razonSocial;
    private String nombreComercial;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean activo;

    public static Proveedor from(ProveedorDTO obj) {
        Proveedor proveedor = new Proveedor();

        proveedor.setTipoIdentificacion(TipoIdentificacion.valueOf(obj.getTipoIdentificacion()));
        proveedor.setIdentificacion(obj.getIdentificacion());
        proveedor.setRazonSocial(obj.getRazonSocial());
        proveedor.setNombreComercial(obj.getNombreComercial());
        proveedor.setTelefono(obj.getTelefono());
        proveedor.setCorreo(obj.getCorreo());
        proveedor.setDireccion(obj.getDireccion());
        proveedor.setActivo(obj.isActivo());
        return proveedor;
    }

    public static ProveedorDTO from(Proveedor obj) {
        ProveedorDTO proveedor = new ProveedorDTO();

        proveedor.setTipoIdentificacion(obj.getTipoIdentificacion().name());
        proveedor.setIdentificacion(obj.getIdentificacion());
        proveedor.setRazonSocial(obj.getRazonSocial());
        proveedor.setNombreComercial(obj.getNombreComercial());
        proveedor.setTelefono(obj.getTelefono());
        proveedor.setCorreo(obj.getCorreo());
        proveedor.setDireccion(obj.getDireccion());
        proveedor.setActivo(obj.isActivo());

        return proveedor;
    }

    public static List<ProveedorDTO> fromProveedoresDTO(List<Proveedor> proveedores) {
        List<ProveedorDTO> dtos = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            ProveedorDTO p = from(proveedor);
            p.setId(proveedor.getId());
            dtos.add(p);
        }
        return dtos;
    }

    public static List<Proveedor> fromProveedores(List<ProveedorDTO> dtos) {
        List<Proveedor> proveedores = new ArrayList<>();
        for (ProveedorDTO proveedor : dtos) {
            Proveedor p = from(proveedor);
            p.setId(proveedor.getId());
            proveedores.add(p);
        }
        return proveedores;
    }

}
