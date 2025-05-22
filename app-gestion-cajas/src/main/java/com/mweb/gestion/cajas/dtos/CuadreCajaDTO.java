package com.mweb.gestion.cajas.dtos;

import com.mweb.gestion.cajas.db.Caja;
import com.mweb.gestion.cajas.db.CuadreCaja;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CuadreCajaDTO {
    private Integer id;
    private String usuario;
    private Integer idNegocio;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;
    private BigDecimal totalIngresosEfectivo;
    private BigDecimal totalIngresosTransferencia;
    private BigDecimal totalGastosEfectivo;
    private BigDecimal totalGastosTransferencia;
    private BigDecimal saldoFinalEfectivo;
    private BigDecimal saldoFinalTransferencia;
    private BigDecimal valorContable;
    private BigDecimal diferencia;
    private BigDecimal valorCierre;
    private BigDecimal valorApertura;
    private boolean estado;
    private Integer cajaId;
    private String cajaNombre;


    public static CuadreCajaDTO from(CuadreCaja cuadreCaja) {
        CuadreCajaDTO dto = new CuadreCajaDTO();
        dto.setId(cuadreCaja.getId());
        dto.setUsuario(cuadreCaja.getUsuario());
        dto.setIdNegocio(cuadreCaja.getIdNegocio());
        dto.setFechaApertura(cuadreCaja.getFechaApertura());
        dto.setFechaCierre(cuadreCaja.getFechaCierre());
        dto.setTotalIngresosEfectivo(cuadreCaja.getTotalIngresosEfectivo());
        dto.setTotalIngresosTransferencia(cuadreCaja.getTotalIngresosTransferencia());
        dto.setTotalGastosEfectivo(cuadreCaja.getTotalGastosEfectivo());
        dto.setTotalGastosTransferencia(cuadreCaja.getTotalGastosTransferencia());
        dto.setSaldoFinalEfectivo(cuadreCaja.getSaldoFinalEfectivo());
        dto.setSaldoFinalTransferencia(cuadreCaja.getSaldoFinalTransferencia());
        dto.setValorContable(cuadreCaja.getValorContable());
        dto.setDiferencia(cuadreCaja.getDiferencia());
        dto.setValorCierre(cuadreCaja.getValorCierre());
        dto.setValorApertura(cuadreCaja.getValorApertura());
        dto.setEstado(cuadreCaja.isEstado());
        dto.setCajaId(cuadreCaja.getCaja().getId());

        if (cuadreCaja.getCaja() != null) {
            dto.setCajaNombre(cuadreCaja.getCaja().getNombre());
        }

        return dto;
    }

    public static CuadreCaja from(CuadreCajaDTO dto) {
        CuadreCaja cuadreCaja = new CuadreCaja();
        cuadreCaja.setId(dto.getId());
        cuadreCaja.setUsuario(dto.getUsuario());
        cuadreCaja.setIdNegocio(dto.getIdNegocio());
        cuadreCaja.setFechaApertura(dto.getFechaApertura());
        cuadreCaja.setFechaCierre(dto.getFechaCierre());
        cuadreCaja.setTotalIngresosEfectivo(dto.getTotalIngresosEfectivo());
        cuadreCaja.setTotalIngresosTransferencia(dto.getTotalIngresosTransferencia());
        cuadreCaja.setTotalGastosEfectivo(dto.getTotalGastosEfectivo());
        cuadreCaja.setTotalGastosTransferencia(dto.getTotalGastosTransferencia());
        cuadreCaja.setSaldoFinalEfectivo(dto.getSaldoFinalEfectivo());
        cuadreCaja.setSaldoFinalTransferencia(dto.getSaldoFinalTransferencia());
        cuadreCaja.setValorContable(dto.getValorContable());
        cuadreCaja.setDiferencia(dto.getDiferencia());
        cuadreCaja.setValorCierre(dto.getValorCierre());
        cuadreCaja.setValorApertura(dto.getValorApertura());
        cuadreCaja.setEstado(dto.isEstado());
        return cuadreCaja;
    }


}