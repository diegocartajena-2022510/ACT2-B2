package com.example.demo.Controller;

import com.example.demo.Entity.Clientes;
import com.example.demo.Service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clientes")

public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {this.clientesService = clientesService;}

    @GetMapping
    public List<Clientes> getAllClientes(){return clientesService.getAllClientes();}

    @PostMapping
    public ResponseEntity<Object> createClientes( @RequestBody Clientes clientes){
        try{
            Clientes createdClientes= clientesService.saveClientes(clientes);
            return new ResponseEntity<>(createdClientes, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClientes(@PathVariable Integer id, @RequestBody Clientes clientes) {
        try{
            Clientes cliente = clientesService.getClientesById(id);
            if (cliente == null) {
                return ResponseEntity.notFound().build();
            }
            clientes.setDpi_cliente(id);

            Clientes updatedCliente = clientesService.updateClientes(id, clientes);
            return ResponseEntity.ok(updatedCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientes(@PathVariable Integer id) {
        try {

            Clientes clientes = clientesService.getClientesById(id);

            clientesService.deleteClientes(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientesById(@PathVariable Integer id) {
        try {
            Clientes clientes= clientesService.getClientesById(id);
            return ResponseEntity.ok(clientes);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
