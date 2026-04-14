package com.example.demo.Controller;


import com.example.demo.Entity.DetalleVenta;
import com.example.demo.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVenta(){ return detalleVentaService.getAlldetalleVenta();}

    @PostMapping
    public ResponseEntity<Object> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta){
        try{
            DetalleVenta createdDetalleVenta= detalleVentaService.savedetalleVenta(detalleVenta);
            return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalleVenta(@PathVariable Integer id, @Valid @RequestBody DetalleVenta detalleVenta) {
        try{
            DetalleVenta detalleVenta1 = detalleVentaService.getdetalleVentaById(id);
            if (detalleVenta1 == null) {
                return ResponseEntity.notFound().build();
            }
            detalleVenta.setCodigo_detalle_venta(id);

            DetalleVenta updatedCliente = detalleVentaService.updatedetalleVenta(id, detalleVenta);
            return ResponseEntity.ok(updatedCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalleVenta(@PathVariable Integer id) {
        try {

            DetalleVenta detalleVenta = detalleVentaService.getdetalleVentaById(id);

            detalleVentaService.deletedetalleVenta(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleVentaById(@PathVariable Integer id) {
        try {
            DetalleVenta detalleVenta= detalleVentaService.getdetalleVentaById(id);
            return ResponseEntity.ok(detalleVenta);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
