package com.ezequiel_creador.erp_ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequiel_creador.erp_ventas.model.Venta;
import com.ezequiel_creador.erp_ventas.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }
    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
    public void updateVenta(Long id, Venta venta) {
            Venta existingVenta = getVentaById(id);
            if (existingVenta != null) {
                existingVenta.setFecha(venta.getFecha());
                existingVenta.setCliente(venta.getCliente());
                existingVenta.setVendedor(venta.getVendedor());
                existingVenta.setTotal(venta.getTotal());
                existingVenta.setEstado(venta.getEstado());
                existingVenta.setFormaPago(venta.getFormaPago());
                existingVenta.setObservaciones(venta.getObservaciones());
                existingVenta.setTipoComprobante(venta.getTipoComprobante());
                existingVenta.setNumeroComprobante(venta.getNumeroComprobante());
                existingVenta.setDescripcion(venta.getDescripcion());
                ventaRepository.save(existingVenta);
            }
        }
    
}
