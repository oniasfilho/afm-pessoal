package com.sucit.afm.rest;

import com.sucit.afm.entity.DispositivoFuncional;
import com.sucit.afm.service.DispositivoFuncionalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DispositivoFuncionalController {

    private final DispositivoFuncionalService service;

    public DispositivoFuncionalController(DispositivoFuncionalService service) {
        this.service = service;
    }

    // criar disp
    @PostMapping("/api/dispositivofuncional")
    public DispositivoFuncional salvarDispositivoFuncional(@RequestBody DispositivoFuncional df){
        df.setId(0);
        service.salvar(df);

        return df;
    }

    //read (listagem geral)
    @GetMapping("/api/dispositivofuncional")
    public List<DispositivoFuncional> listarTodos(){

        return service.listarTodos();
    }

    // read disp por id
    @GetMapping("/api/dispositivofuncional/{id}")
    public DispositivoFuncional buscarPorId(@PathVariable int id){
        return service.acharPorId(id);
    }

    // atualizar disp
    @PutMapping("/api/dispositivofuncional")
    public DispositivoFuncional atualizaDF(@RequestBody DispositivoFuncional df){



        service.salvar(df);

        return df;
    }

    // deletar disp por id
    @DeleteMapping("/api/dispositivofuncional/{id}")
    public int deletaPorId(@PathVariable int id){
        service.deletarPorId(id);

        return id;
    }
}
