package com.ezequiel_creador.erp_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezequiel_creador.erp_ventas.model.EstadoVenta;
import com.ezequiel_creador.erp_ventas.model.FormaPago;
import com.ezequiel_creador.erp_ventas.model.TipoComprobante;
import com.ezequiel_creador.erp_ventas.model.Venta;
import com.ezequiel_creador.erp_ventas.service.VentaService;



@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired 
    private VentaService ventaService;

     @ModelAttribute("estados")
    public EstadoVenta[] estados() {
        return EstadoVenta.values();
    }

    @ModelAttribute("formasPago")
    public FormaPago[] formasPago() {
        return FormaPago.values();
    }

    @ModelAttribute("tiposComprobante")
    public TipoComprobante[] tiposComprobante() {
        return TipoComprobante.values();
    } 

   @GetMapping("/listar")
    public String listarVentas(Model model) {
    List<Venta> ventas = ventaService.getAllVentas();
    model.addAttribute("ventas", ventas);
    return "listar"; // Thymeleaf buscará listar.html en templates
}
    @GetMapping("/nueva")
    public String nuevaVentaForm(Model model) {
        model.addAttribute("venta", new Venta());
        return "nueva_venta";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
    ventaService.saveVenta(venta);
    return "redirect:/ventas/listar";
}

    @PostMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
    ventaService.deleteVenta(id);
    return "redirect:/ventas/listar";
}
   
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
    Venta venta = ventaService.getVentaById(id);
    model.addAttribute("venta", venta);
    return "nueva_venta"; // o una nueva vista llamada editar_venta.html si querés separarlo
}

  
    
}
