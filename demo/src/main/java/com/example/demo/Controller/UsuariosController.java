package com.example.demo.Controller;


import com.example.demo.Repository.UsuariosRepository;
import org.hibernate.sql.model.PreparableMutationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuariosService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @GetMapping("/")
    public String inicio() {return "redirect:/login";}

    @GetMapping("/login")
    public String mostrarLogin(){return "login";}

    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){
        Usuarios u = service.login(usuario, password);
        if (u != null) {
            session.setAttribute("usuarioLogeado", u);
            return "redirect:/principal";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register() {return "register";}

    @PostMapping("/register")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String password,
                          @RequestParam String email,
                          Model model) {

        Usuarios u = service.registrar(usuario, password,email);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "register";
        }
        return "redirect:/login";
    }


    @GetMapping("/principal")
    public String mostrarPrincipal(HttpSession session){
        // valida la sesion
        if (session.getAttribute("usuarioLogeado") == null) {
            return "redirect:/login";
        }
        return "principal";
    }


    @GetMapping("/usuarios")
    public String mostrarUsuarios(@RequestParam(name = "accion", required = false) String accion,
                                  @RequestParam(name = "id", required = false) Integer id,
                                  Model model) {

        model.addAttribute("usuarios", service.listar());
        model.addAttribute("accion", accion);

        if ("editar".equals(accion) && id != null) {
            model.addAttribute("uEncontrado", service.buscarPorId(id));
        } else {
            model.addAttribute("uEncontrado", new Usuarios());
        }

        return "usuarios";
    }

    @PostMapping("/usuarios/agregar")
    public String agregar ( @ModelAttribute Usuarios usuarios){
        service.guardar(usuarios);
        return "redirect:/usuarios";
    }
    @PostMapping("/usuarios/buscar")
    public String buscar(@RequestParam Integer codigo_usuario, Model model) {
        if (codigo_usuario != null) {
            Usuarios u = service.buscarPorId(codigo_usuario);
            if (u != null) {
                model.addAttribute("uEncontrado", u);
            } else {
                model.addAttribute("error", "Usuario no encontrado");
            }
        }
        model.addAttribute("usuarios",service.listar());
        return "usuarios";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        model.addAttribute("usuarioNuevo",service.buscarPorId(id));
        model.addAttribute("usuarios",service.listar());
        return "usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        service.eliminar(id);
        return "redirect:/usuarios";
    }



    
    
}

