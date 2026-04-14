package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {

    @GetMapping("/")
    public String inicio() {return "redirect:/login";}

    @GetMapping("/login")
    public String mostrarLogin(){return "login";}

    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){
        String userCorrecto="admin";
        String passCorrecto="1234";

        if (usuario.equals(userCorrecto)&& password.equals(passCorrecto)){
            // guarda sesion
            session.setAttribute("usuarioLogeado",usuario);
            return "redirect:/principal";
        }else{
            model.addAttribute("error","usuario y contraseña incorrectas");
            return "login";
        }
    }

    @GetMapping("/principal")
    public String mostrarPrincipal(HttpSession session){
        // valida la sesion
        if (session.getAttribute("usuarioLogeado") == null) {
            return "redirect:/login";
        }
        return "principal";
    }


    @GetMapping("/register")
    public String register() {return "register";}
    


}
