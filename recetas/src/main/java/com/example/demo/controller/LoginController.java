package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpSession session) {
        Usuario usuario = usuarioService.findByLoginAndPassword(login, password);
        if (usuario == null) {
            // usuario o contraseña incorrectos
            return "redirect:/";
        }
        //login correcto
        session.setAttribute("usuario", usuario);
        /* no implementado */
        switch (usuario.getRol()) {
            case ADMINISTRADOR:
                return "redirect:/homeAdministrador";
            case MÉDICO:
                return "redirect:/homeMedico";
            case PACIENTE:
                return "redirect:/homePaciente";
            case FARMACIA:
                return "redirect:/homeFarmacia";
            default:
                return "redirect:/homeNoRol";
        }

    }
}