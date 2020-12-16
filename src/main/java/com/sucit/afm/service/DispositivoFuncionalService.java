package com.sucit.afm.service;

import com.sucit.afm.entity.DispositivoFuncional;

import java.util.List;

public interface DispositivoFuncionalService {
    public List<DispositivoFuncional> listarTodos();

    public DispositivoFuncional acharPorId(int id);

    public void salvar(DispositivoFuncional dispositivoFuncional);

    public void deletarPorId(int id);
}
