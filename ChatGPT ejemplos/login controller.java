@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Usuario usuario = usuarioRepository.findByLoginAndPassword(login, password);
        if (usuario == null) {
            // usuario o contraseña incorrectos
            return "redirect:/";
        } else {
            // inicio de sesión correcto
            session.setAttribute("usuario", usuario);
            return "redirect:/home";
        }
    }
}