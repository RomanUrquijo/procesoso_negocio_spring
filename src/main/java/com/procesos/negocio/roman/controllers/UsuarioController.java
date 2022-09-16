package com.procesos.negocio.roman.controllers;

import com.procesos.negocio.roman.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UsuarioController {
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Roman");
        usuario.setApellidos("Urquijo");
        usuario.setDocumento("1007961049");
        usuario.setDireccion("dhshs");
        usuario.setFechaNacimiento(new Date(2000,8,12));
        usuario.setTelefono("3134437080");
        return usuario;
    }
}
