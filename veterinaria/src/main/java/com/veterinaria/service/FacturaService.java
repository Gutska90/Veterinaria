package com.veterinaria.service;

import com.veterinaria.model.Factura;
import com.veterinaria.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> buscarPorId(Long id) {
        return facturaRepository.findById(id);
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizar(Long id, Factura facturaActualizada) {
        return facturaRepository.findById(id)
                .map(factura -> {
                    factura.setFechaEmision(facturaActualizada.getFechaEmision());
                    factura.setTotalBruto(facturaActualizada.getTotalBruto());
                    factura.setIva(facturaActualizada.getIva());
                    factura.setTotalFinal(facturaActualizada.getTotalFinal());
                    return facturaRepository.save(factura);
                })
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        facturaRepository.deleteById(id);
    }
}
