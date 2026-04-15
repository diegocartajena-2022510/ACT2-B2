package com.example.demo.Service;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService{
    @Autowired
    private UsuariosRepository repo;

    @Override
    public Usuarios registrar(String usuario, String password, String email) {
        if(repo.findByUsername(usuario)!=null){
            return null;
        }
        Usuarios u= new Usuarios();
        u.setUsername(usuario);
        u.setPasword(password);
        u.setEmail(email);
        return repo.save(u);
    }

    @Override
    public Usuarios login(String usuarios, String password) {
        Usuarios u = repo.findByUsername(usuarios);

        if (u != null && u.getPasword().equals(password)) {
            return u;
        }

        return null;
    }
    @Override
    public List<Usuarios> listar() {
        return repo.findAll();
    }

    @Override
    public Usuarios guardar(Usuarios usuarios) {
        return repo.save(usuarios);
    }

    @Override
    public Usuarios buscarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id){
        repo.deleteById(id);
    }
}
