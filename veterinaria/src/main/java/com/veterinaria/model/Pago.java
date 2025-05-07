package com.veterinaria.model;

import lombok.Data;

@Data
public class Pago {
    private Long id;
    private Factura factura;
    private Double montoPagado;
    private String fechaPago;
    private String metodoPago;
}
