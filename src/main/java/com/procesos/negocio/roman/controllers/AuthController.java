package com.procesos.negocio.roman.controllers;

import com.procesos.negocio.roman.models.Usuario;
import com.procesos.negocio.roman.services.UsuarioService;
import com.procesos.negocio.roman.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping (value = "auth/login")
    public ResponseEntity login(@RequestBody Usuario usuario){
       return usuarioService.login(usuario.getCorreo(), usuario.getPassword());
    }
}
