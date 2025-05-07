package com.veterinaria.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDTO {
    
    private Long id;

    @NotNull(message = "La factura es obligatoria")
    private Long facturaId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor que 0")
    private BigDecimal monto;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDateTime fechaPago;

    @NotBlank(message = "El método de pago es obligatorio")
    @Size(min = 3, max = 50, message = "El método de pago debe tener entre 3 y 50 caracteres")
    private String metodoPago;

    @Size(max = 100, message = "La referencia no puede exceder los 100 caracteres")
    private String referencia;

    @NotNull(message = "El estado del pago es obligatorio")
    private String estado;
} 