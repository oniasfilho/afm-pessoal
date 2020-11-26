package com.sucit.afm.rest;

import com.sucit.afm.entity.Usuario;
import com.sucit.afm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioRestController {

    UsuarioService service;

    @Autowired
    public UsuarioRestController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/api/usuarios")
    public List<Usuario> listarTodos(){
        return service.listarTodos();
    }
}
