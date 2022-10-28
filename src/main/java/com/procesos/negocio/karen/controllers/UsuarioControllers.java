package com.procesos.negocio.karen.controllers;

import aj.org.objectweb.asm.Opcodes;
import com.procesos.negocio.karen.models.Usuario;
import com.procesos.negocio.karen.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UsuarioControllers {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario/{id}")

    public ResponseEntity getUsuario(@PathVariable Long id) {
        return usuarioService.getUserById(id);
    }

    @PostMapping("/usuario")

    public ResponseEntity crearUsuario( @Valid @RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }


    @GetMapping("/usuarios")
    public ResponseEntity listarUsuarios() {
        return usuarioService.allUsers();
    }

    @GetMapping("/usuario/{nombre}/{apellidos}")
    public ResponseEntity ListarPorNombreApellidos(@PathVariable String nombre, @PathVariable String apellidos) {
        return usuarioService.allUsersByNameAndLastName(nombre,apellidos);
    }

    @GetMapping("/usuarios/nombre/{nombre}")

    public ResponseEntity ListarPorNombre(@PathVariable String nombre) {
        return usuarioService.allUsersByName(nombre);
    }

    @GetMapping("/usuarios/apellidos/{apellidos}")

    public ResponseEntity ListarPorApellidos(@PathVariable String apellidos) {
        return usuarioService.allUsersByLastName(apellidos);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity editarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.editUser(id,usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        return usuarioService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}