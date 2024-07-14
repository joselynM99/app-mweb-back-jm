package com.mweb.clientes.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mweb.clientes.db.Deuda;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class DeudaDTO {

    private Integer id;

    private BigDecimal total;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha;
    private Boolean estado;

    private String clienteId;
    private String clienteNombre;
    private List<DetalleDeudaDTO> detalles;
    private List<AbonoDTO> abonos;

    public static Deuda from(DeudaDTO obj) {
        Deuda deuda = new Deuda();
        deuda.setId(obj.getId());
        deuda.setTotal(obj.getTotal());
        deuda.setFecha(obj.getFecha());
        deuda.setEstado(obj.getEstado());
        return deuda;
    }

    public static DeudaDTO from(Deuda obj) {
        DeudaDTO deuda = new DeudaDTO();
        deuda.setId(obj.getId());
        deuda.setTotal(obj.getTotal());
        deuda.setFecha(obj.getFecha());
        deuda.setEstado(obj.getEstado());
        deuda.setClienteNombre(obj.getCliente().getNombres() + ' ' + obj.getCliente().getApellidos());
        deuda.setClienteId(obj.getCliente().getIdentificacion());
        return deuda;
    }


    public static List<DeudaDTO> fromDeudasDTO(List<Deuda> deudas) {
        List<DeudaDTO> dtos = new ArrayList<>();
        for (Deuda deuda : deudas) {
            DeudaDTO d = from(deuda);
            d.setId(deuda.getId());

            dtos.add(d);
        }
        return dtos;
    }

    public static List<Deuda> fromDeudas(List<DeudaDTO> deudas) {
        List<Deuda> deudasList = new ArrayList<>();
        for (DeudaDTO deuda : deudas) {
            Deuda d = from(deuda);
            d.setId(deuda.getId());
            deudasList.add(d);
        }
        return deudasList;
    }
}
