package com.example.demo.Service;

import com.example.demo.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuariosById(Integer id);
    Usuarios saveUsuarios(Usuarios usuarios)throws RuntimeException;
    Usuarios updateUsuarios(Integer id, Usuarios usuarios ) ;
    void deleteUsuarios(Integer id);
}
