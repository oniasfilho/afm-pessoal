package com.sucit.afm.rest;

import com.sucit.afm.entity.DispositivoPessoal;
import com.sucit.afm.service.DispositivoPessoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DispositivoPessoalController {

    private DispositivoPessoalService service;

    public DispositivoPessoalController(DispositivoPessoalService service) {
        this.service = service;
    }


    @GetMapping("/api/dispositivopessoal")
    public List<DispositivoPessoal> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/api/dispositivopessoal/{id}")
    public DispositivoPessoal buscarPorId(@PathVariable int id){
        DispositivoPessoal dp1 = service.acharPorId(id);

        return dp1;
    }

    @PostMapping("/api/dispositivopessoal")
    public DispositivoPessoal salvarDispositivoPessoal(@RequestBody DispositivoPessoal dp){
        dp.setId(0);

        service.salvar(dp);
        return dp;
    }

    @PutMapping("/api/dispositivopessoal")
    public DispositivoPessoal atualizaDP(@RequestBody DispositivoPessoal dp){
        service.salvar(dp);

        return dp;
    }

    @DeleteMapping("/api/dispositivopessoal/{id}")
    public int deletaDP(@PathVariable int id){
        service.deletarPorId(id);

        return id;
    }









}
