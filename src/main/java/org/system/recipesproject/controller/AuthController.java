package org.system.recipesproject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.system.recipesproject.services.AuthService;

import java.util.Map;
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    // Affiche la page de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // correspond à login.html dans templates
    }


    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session) {

        if (authService.authenticate(email, password)) {
            session.setAttribute("userEmail", email); // Sauvegarde l'email dans la session
            return "redirect:/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        String userEmail = (String) session.getAttribute("userEmail");

        if (userEmail == null) {
            return "redirect:/login"; // Redirige si l'utilisateur n'est pas connecté
        }

        return "ingredientForm";
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // correspond à register.html dans templates
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Les mots de passe ne correspondent pas.");
            return "register";
        }

        boolean registered = authService.register(email, password);
        if (!registered) {
            model.addAttribute("error", "Un compte avec cet email existe déjà.");
            return "register";
        }

        return "redirect:/login";
    }

}
