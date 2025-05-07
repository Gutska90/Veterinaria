package com.veterinaria.service;

import com.veterinaria.model.Pago;
import com.veterinaria.repository.PagoRepository;
import com.veterinaria.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> buscarPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago guardar(Pago pago) {
        // Validar que la factura exista
        Long idFactura = pago.getFactura().getId();
        facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + idFactura));
        return pagoRepository.save(pago);
    }

    public Pago actualizar(Long id, Pago pagoActualizado) {
        return pagoRepository.findById(id)
                .map(pago -> {
                    pago.setFactura(pagoActualizado.getFactura());
                    pago.setMontoPagado(pagoActualizado.getMontoPagado());
                    pago.setFechaPago(pagoActualizado.getFechaPago());
                    pago.setMetodoPago(pagoActualizado.getMetodoPago());
                    return pagoRepository.save(pago);
                })
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }
}
