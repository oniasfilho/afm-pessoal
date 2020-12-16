package com.sucit.afm.dao;

import com.sucit.afm.entity.DispositivoFuncional;
import com.sucit.afm.entity.DispositivoPessoal;

import java.util.List;

public interface DispositivoFuncionalDAO {
    public List<DispositivoFuncional> listarTodos();

    public DispositivoFuncional acharPorId(int id);

    public void salvar(DispositivoFuncional dispositivoFuncional);

    public void deletarPorId(int id);

}
