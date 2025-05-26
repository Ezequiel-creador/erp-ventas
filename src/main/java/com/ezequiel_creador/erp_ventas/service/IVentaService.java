package com.ezequiel_creador.erp_ventas.service;

import java.util.List;

import com.ezequiel_creador.erp_ventas.model.Venta;

public interface IVentaService {
    public List<Venta> getAllVentas();
    public Venta getVentaById(Long id);
    public void saveVenta(Venta venta);
    public void deleteVenta(Long id);
    public void updateVenta(Long id, Venta venta);
}
