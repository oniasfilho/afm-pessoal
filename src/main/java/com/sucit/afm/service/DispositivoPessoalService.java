package com.sucit.afm.service;

import com.sucit.afm.entity.DispositivoPessoal;

import java.util.List;

public interface DispositivoPessoalService {
    public List<DispositivoPessoal> listarTodos();

    public DispositivoPessoal acharPorId(int id);

    public void salvar(DispositivoPessoal dispositivoPessoal);

    public void deletarPorId(int id);
}
