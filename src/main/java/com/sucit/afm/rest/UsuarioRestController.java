package com.sucit.afm.rest;

import com.sucit.afm.entity.DispositivoFuncional;
import com.sucit.afm.entity.DispositivoPessoal;
import com.sucit.afm.entity.Usuario;
import com.sucit.afm.service.DispositivoFuncionalService;
import com.sucit.afm.service.DispositivoPessoalService;
import com.sucit.afm.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);



    private UsuarioService service;
    private DispositivoFuncionalService dfservice;

    public UsuarioRestController(UsuarioService service, DispositivoFuncionalService dfservice) {
        this.service = service;
        this.dfservice = dfservice;
    }

    @Autowired
    private DispositivoPessoalService dservice;



    @GetMapping("/api/usuarios")
    public List<Usuario> listarTodos(){
        logger.trace("Chegou na listagem de usuarios");


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

    @PutMapping("/api/usuarios/{id}")
    public Usuario atualizaUsuarioTeste(@RequestBody Usuario usuario, @PathVariable int id){

        DispositivoFuncional df = dfservice.acharPorId(id);

        usuario.setDispositivoFuncional(df);

        service.salvar(usuario);
        return usuario;
    }

    @DeleteMapping("/api/usuarios/{usuarioId}")
    public int deletaUsuario(@PathVariable int usuarioId){

        service.deletarPorId(usuarioId);

        return usuarioId;
    }






}
