package com.ezequiel_creador.erp_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezequiel_creador.erp_ventas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

}
