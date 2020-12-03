package com.sucit.afm.rest;

import com.sucit.afm.entity.Dispositivo;
import com.sucit.afm.entity.Usuario;
import com.sucit.afm.service.DispositivoService;
import com.sucit.afm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    private UsuarioService service;

    @Autowired
    private DispositivoService dservice;

    @Autowired
    public UsuarioRestController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/api/usuarios")
    public List<Usuario> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/api/usuarios/{usuarioId}")
    public Usuario buscaUsuario(@PathVariable int usuarioId){
        Usuario u1 = service.acharPorId(usuarioId);

        if(u1 == null){
            throw new RuntimeException("Usuário não encontrado - " + usuarioId);
        }

        return  u1;
    }

    @PostMapping("/api/usuarios")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        usuario.setId(0);

        service.salvar(usuario);
        return usuario;
    }

    @PutMapping("/api/usuarios")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario){
        service.salvar(usuario);
        return usuario;
    }

    @DeleteMapping("/api/usuarios/{usuarioId}")
    public int deletaUsuario(@PathVariable int usuarioId){
        service.deletarPorId(usuarioId);
        return usuarioId;
    }

    @PostMapping("/api/usuarios/dispositivo/{dispId}")
    public HttpStatus salvarDispositivo(@RequestBody Usuario usuario, @PathVariable int dispId){

        Dispositivo d1 = dservice.acharPorId(dispId);

        usuario.addDispositivo(d1);

        service.salvar(usuario);

        return HttpStatus.OK;
    }





}
