package com.mweb.gestion.cajas.service;

import com.mweb.gestion.cajas.db.Adicionales;
import com.mweb.gestion.cajas.db.Caja;
import com.mweb.gestion.cajas.db.CuadreCaja;
import com.mweb.gestion.cajas.dtos.AdicionalesDTO;
import com.mweb.gestion.cajas.dtos.CajaDTO;
import com.mweb.gestion.cajas.dtos.CuadreCajaDTO;
import com.mweb.gestion.cajas.repo.AdicionalesRepository;
import com.mweb.gestion.cajas.repo.CajaRepository;
import com.mweb.gestion.cajas.repo.CuadreCajaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CuadreCajaService {

    @Inject
    CajaRepository cajaRepository;

    @Inject
    AdicionalesRepository adicionalesRepository;

    @Inject
    CuadreCajaRepository cuadreCajaRepository;

    public CajaDTO crearCaja(CajaDTO cajaDTO) {
        Caja caja = CajaDTO.from(cajaDTO);
        caja.setActivo(true);
        cajaRepository.persist(caja);
        return CajaDTO.from(caja);
    }

    public List<CajaDTO> obtenerCajasActivasPorNegocio(Integer idNegocio) {
        List<Caja> cajas = cajaRepository.find("idNegocio = ?1 and activo = true", idNegocio).list();
        return cajas.stream().map(CajaDTO::from).collect(Collectors.toList());
    }

    public void desactivarCaja(Integer idCaja) {
        Caja caja = cajaRepository.findById(idCaja);
        if (caja != null) {
            caja.setActivo(false);
        }
    }

    public CajaDTO actualizarCaja(CajaDTO cajaDTO) {
        Caja caja = cajaRepository.findById(cajaDTO.getId());
        if (caja != null) {
            caja.setNombre(cajaDTO.getNombre());
            return CajaDTO.from(caja);
        }
        return null;
    }

    public AdicionalesDTO registrarAdicional(AdicionalesDTO adicionalesDTO) {
        Adicionales adicionales = AdicionalesDTO.from(adicionalesDTO);
        adicionales.setActivo(true);

        CuadreCaja cuadreCaja = cuadreCajaRepository.findById(adicionalesDTO.getCuadreCajaId());
        adicionales.setCuadreCaja(cuadreCaja);
        //System.out.println("Adicionales: " + adicionales.toString());
        adicionalesRepository.persist(adicionales);
        return AdicionalesDTO.from(adicionales);
    }

    public List<AdicionalesDTO> obtenerAdicionalesActivosPorCuadreCaja(Integer idCuadreCaja) {
        List<Adicionales> adicionales = adicionalesRepository.find("cuadreCaja.id = ?1 and activo = true", idCuadreCaja).list();
        return adicionales.stream().map(AdicionalesDTO::from).collect(Collectors.toList());
    }

    public void desactivarAdicional(Integer idAdicional) {
        Adicionales adicionales = adicionalesRepository.findById(idAdicional);
        if (adicionales != null) {
            adicionales.setActivo(false);
        }
    }

    public CuadreCajaDTO abrirCaja(CuadreCajaDTO cuadreCajaDTO) {
        Caja caja = cajaRepository.findById(cuadreCajaDTO.getCajaId());
        if (caja == null) {
            throw new IllegalArgumentException("Caja not found");
        }
        CuadreCaja cuadreCaja = new CuadreCaja();
        cuadreCaja.setUsuario(cuadreCajaDTO.getUsuario());
        cuadreCaja.setIdNegocio(cuadreCajaDTO.getIdNegocio());
        cuadreCaja.setFechaApertura(cuadreCajaDTO.getFechaApertura());
        cuadreCaja.setValorApertura(cuadreCajaDTO.getValorApertura());
        cuadreCaja.setEstado(true);
        cuadreCaja.setCaja(caja);
        cuadreCajaRepository.persist(cuadreCaja);
        return CuadreCajaDTO.from(cuadreCaja);
    }

    public List<CuadreCajaDTO> buscarCuadreCaja(String usuario, LocalDateTime fechaInicio, LocalDateTime fechaFin, Boolean estado, Integer idNegocio) {
        String query = "idNegocio = ?1";
        if (usuario != null) {
            query += " and usuario = ?2";
        }
        if (fechaInicio != null && fechaFin != null) {
            query += " and fechaApertura between ?3 and ?4";
        }
        if (estado != null) {
            query += " and estado = ?5";
        }
        query += " order by fechaApertura";
        List<CuadreCaja> cuadreCajas = cuadreCajaRepository.find(query, idNegocio, usuario, fechaInicio, fechaFin, estado).list();
        return cuadreCajas.stream().map(CuadreCajaDTO::from).collect(Collectors.toList());
    }

    public CuadreCajaDTO cerrarCaja(CuadreCajaDTO cuadreCajaDTO) {
        CuadreCaja cuadreCaja = cuadreCajaRepository.findById(cuadreCajaDTO.getId());
        if (cuadreCaja == null) {
            throw new IllegalArgumentException("CuadreCaja not found");
        }
        cuadreCaja.setFechaCierre(cuadreCajaDTO.getFechaCierre());
        cuadreCaja.setTotalIngresosEfectivo(cuadreCajaDTO.getTotalIngresosEfectivo());
        cuadreCaja.setTotalIngresosTransferencia(cuadreCajaDTO.getTotalIngresosTransferencia());
        cuadreCaja.setTotalGastosEfectivo(cuadreCajaDTO.getTotalGastosEfectivo());
        cuadreCaja.setTotalGastosTransferencia(cuadreCajaDTO.getTotalGastosTransferencia());
        cuadreCaja.setSaldoFinalEfectivo(cuadreCajaDTO.getSaldoFinalEfectivo());
        cuadreCaja.setSaldoFinalTransferencia(cuadreCajaDTO.getSaldoFinalTransferencia());
        cuadreCaja.setDiferencia(cuadreCajaDTO.getDiferencia());
        cuadreCaja.setValorCierre(cuadreCajaDTO.getValorCierre());
        cuadreCaja.setValorContable(cuadreCajaDTO.getValorContable());
        cuadreCaja.setEstado(false);
        return CuadreCajaDTO.from(cuadreCaja);
    }

    public CuadreCajaDTO buscarCuadreCajaActivoPorUsuario(String usuario, Integer idNegocio) {
        List<CuadreCaja> cuadreCajas = cuadreCajaRepository.find("usuario = ?1 and idNegocio = ?2 and estado = true order by fechaApertura desc", usuario, idNegocio).list();
        if (cuadreCajas.isEmpty()) {
            return null;
        }
        CuadreCaja activeCuadreCaja = cuadreCajas.get(0);
        for (int i = 1; i < cuadreCajas.size(); i++) {
            CuadreCaja cuadreCaja = cuadreCajas.get(i);
            cuadreCaja.setEstado(false);
        }
        return CuadreCajaDTO.from(activeCuadreCaja);
    }
}