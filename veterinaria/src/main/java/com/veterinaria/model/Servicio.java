package com.veterinaria.model;

import lombok.Data;

@Data
public class Servicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double costo;
}
