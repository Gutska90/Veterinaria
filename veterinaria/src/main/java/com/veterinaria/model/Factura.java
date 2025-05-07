package com.veterinaria.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Factura {
    private Long id;
    private String fechaEmision;
    private Double totalBruto;
    private Double iva;
    private Double totalFinal;
    private BigDecimal total;
    private boolean pagada;
}
