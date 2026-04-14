package com.example.demo.Service;

import com.example.demo.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuariosService {

    Usuarios registrar(String usuario, String password, String email);
    Usuarios login(String usuarios, String password);
    List<Usuarios> listar();
    void eliminar(int id);

}
