package com.example.demo.Repository;


import com.example.demo.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
    Usuarios findByUsername(String usuarios);
}
