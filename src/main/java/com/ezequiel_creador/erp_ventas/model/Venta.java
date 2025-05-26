package com.ezequiel_creador.erp_ventas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ezequiel_creador.erp_ventas.model.EstadoVenta;
import com.ezequiel_creador.erp_ventas.model.FormaPago;
import com.ezequiel_creador.erp_ventas.model.TipoComprobante;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String cliente;
    private String vendedor;
    private double total;
    @Enumerated(EnumType.STRING)
    private EstadoVenta estado;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    private String observaciones;
    @Enumerated(EnumType.STRING)
    private TipoComprobante tipoComprobante;
    private String numeroComprobante;
    private String descripcion;
    
}
