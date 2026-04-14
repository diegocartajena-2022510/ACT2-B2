package com.example.demo.Controller;


import com.example.demo.Entity.Ventas;
import com.example.demo.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas(){return ventasService.getAllVentas();}

    @PostMapping
    public ResponseEntity<Object> createClientes(@Valid @RequestBody Ventas ventas){
        try{
            Ventas createdVentas= ventasService.saveVentas(ventas);
            return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVentas(@PathVariable Integer id, @Valid @RequestBody Ventas ventas) {
        try{
            Ventas ventas1 = ventasService.getVentasById(id);
            if (ventas1 == null) {
                return ResponseEntity.notFound().build();
            }
            ventas.setCodigo_venta(id);

            Ventas updateVentas = ventasService.updateVentas(id, ventas);
            return ResponseEntity.ok(updateVentas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVentas(@PathVariable Integer id) {
        try {

            Ventas ventas = ventasService.getVentasById(id);

            ventasService.deleteVentas(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientesById(@PathVariable Integer id) {
        try {
            Ventas ventas= ventasService.getVentasById(id);
            return ResponseEntity.ok(ventas);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
