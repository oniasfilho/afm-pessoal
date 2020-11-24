package com.sucit.afm.rest;

import com.sucit.afm.entity.Dispositivo;
import com.sucit.afm.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivoRestController {


    private DispositivoService service;

    @Autowired
    public DispositivoRestController(DispositivoService service) {
        this.service = service;
    }

    @GetMapping("/dispositivos")
    public List<Dispositivo> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/dispositivos/{dispositivoId}")
    public Dispositivo buscaDispositivo(@PathVariable int dispositivoId){
        Dispositivo d1 = service.acharPorId(dispositivoId);

        if(d1 == null){
            throw new RuntimeException("Dispositivo nao encontrado - " + dispositivoId);
        }

        return d1;
    }

    @PostMapping("/dispositivos")
    public Dispositivo salvarDispositivo(@RequestBody Dispositivo dispositivo){
        dispositivo.setId(0);

        service.salvar(dispositivo);
        return dispositivo;
    }


    @PutMapping("/dispositivos")
    public Dispositivo atualizaDispositivo(@RequestBody Dispositivo dispositivo){

        service.salvar(dispositivo);
        return dispositivo;
    }

    @DeleteMapping("/dispositivos/{dispositivoId}")
    public int deletaDispositivo(@PathVariable int dispositivoId){

        service.deletarPorId(dispositivoId);

        return dispositivoId;
    }
}