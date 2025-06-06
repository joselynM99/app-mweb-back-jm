package com.mweb.transacciones.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mweb.transacciones.db.Abono;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class AbonoDTO {

    private Integer id;
    private BigDecimal monto;
    private Integer idDeuda;
    private Integer idCuadreCaja;
    private Boolean pagoTransferencia;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha;

    public static AbonoDTO from(Abono obj) {
        AbonoDTO ab = new AbonoDTO();
        ab.setFecha(obj.getFecha());
        ab.setId(obj.getId());
        ab.setMonto(obj.getMonto());
        ab.setIdDeuda(obj.getDeuda().getId());
        ab.setIdCuadreCaja(obj.getIdCuadreCaja());
        ab.setPagoTransferencia(obj.getPagoTransferencia());

        return ab;
    }

    public static List<AbonoDTO> fromAbonoDTO(List<Abono> abonos) {
        List<AbonoDTO> dtos = new ArrayList<>();
        for (Abono abono : abonos) {
            AbonoDTO d = from(abono);
            d.setId(abono.getId());
            dtos.add(d);
        }
        return dtos;
    }
}
