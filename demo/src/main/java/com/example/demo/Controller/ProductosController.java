package com.example.demo.Controller;


import com.example.demo.Entity.Productos;
import com.example.demo.Service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Productos")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }
    @GetMapping
    public List<Productos> getAllProductos(){return productosService.getAllProductos();}

    @PostMapping
    public ResponseEntity<Object> createProductos(@Valid @RequestBody Productos productos){
        try{
            Productos createdProductos= productosService.saveProductos(productos);
            return new ResponseEntity<>(createdProductos, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductos(@PathVariable Integer id, @Valid @RequestBody Productos productos) {
        try{
            Productos productos1 = productosService.getProductosById(id);
            if (productos1 == null) {
                return ResponseEntity.notFound().build();
            }
            productos.setCodigo_producto(id);

            Productos updatedProductos = productosService.updateProductos(id, productos);
            return ResponseEntity.ok(updatedProductos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductos(@PathVariable Integer id) {
        try {

            Productos productos = productosService.getProductosById(id);

            productosService.deleteProductos(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientesById(@PathVariable Integer id) {
        try {
            Productos productos= productosService.getProductosById(id);
            return ResponseEntity.ok(productos);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
