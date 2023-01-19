package es.uvigo.dagss.recetas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uvigo.dagss.recetas.entidades.Usuario;
import es.uvigo.dagss.recetas.service.UsuarioService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listAll")
    public String listAll() {
        List<Usuario> lista = usuarioService.listAllUsuario();
        if (lista.size() == 0){
            return "tamaño 0";
        }
            return usuarioService.listAllUsuario().toString();
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpSession session) {
        Usuario usuario = usuarioService.findByLoginAndPassword(login, password);
        if (usuario == null) {
            // usuario o contraseña incorrectos
            return "redirect:/";
        }
        // login correcto
        session.setAttribute("usuario", usuario);
        /* no implementado */
        return "redirect:/home" + usuario.getTipo().toString();
    }
}