package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", service.listar());
        
        return "usuarios"; 
    }
    
    
}

