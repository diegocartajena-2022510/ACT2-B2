package com.example.demo.Controller;


import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios(){return usuariosService.getAllUsuarios();}

    @PostMapping
    public ResponseEntity<Object> createUsuarios(@Valid @RequestBody Usuarios usuarios){
        try{
            Usuarios createdUsuarios= usuariosService.saveUsuarios(usuarios);
            return new ResponseEntity<>(createdUsuarios, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuarios(@PathVariable Integer id, @Valid @RequestBody Usuarios usuarios) {
        try{
            Usuarios usuarios1 = usuariosService.getUsuariosById(id);
            if (usuarios1 == null) {
                return ResponseEntity.notFound().build();
            }
            usuarios.setCodigo_usuario(id);

            Usuarios updateUsuarios = usuariosService.updateUsuarios(id, usuarios);
            return ResponseEntity.ok(updateUsuarios);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarios(@PathVariable Integer id) {
        try {

            Usuarios usuarios = usuariosService.getUsuariosById(id);

            usuariosService.deleteUsuarios(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuariosById(@PathVariable Integer id) {
        try {
            Usuarios usuarios= usuariosService.getUsuariosById(id);
            return ResponseEntity.ok(usuarios);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
