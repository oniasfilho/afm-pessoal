package com.sucit.afm.dao;

import com.sucit.afm.entity.DispositivoPessoal;

import java.util.List;

public interface DispositivoPessoalDAO {

    public List<DispositivoPessoal> listarTodos();

    public DispositivoPessoal acharPorId(int id);

    public void salvar(DispositivoPessoal dispositivoPessoal);

    public void deletarPorId(int id);
}
