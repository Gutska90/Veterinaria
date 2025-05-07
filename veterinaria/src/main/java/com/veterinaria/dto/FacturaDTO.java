package com.veterinaria.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDTO {
    
    private Long id;

    @NotBlank(message = "El número de factura es obligatorio")
    @Size(min = 5, max = 20, message = "El número de factura debe tener entre 5 y 20 caracteres")
    private String numeroFactura;

    @NotNull(message = "La fecha de emisión es obligatoria")
    private LocalDateTime fechaEmision;

    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    @NotEmpty(message = "La factura debe tener al menos un detalle")
    @Valid
    private List<DetalleFacturaDTO> detalles;

    @NotNull(message = "El subtotal es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El subtotal debe ser mayor que 0")
    private BigDecimal subtotal;

    @NotNull(message = "El IVA es obligatorio")
    @DecimalMin(value = "0.0", message = "El IVA no puede ser negativo")
    private BigDecimal iva;

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor que 0")
    private BigDecimal total;

    @NotNull(message = "El estado de la factura es obligatorio")
    private String estado;

    private boolean pagada;
} 