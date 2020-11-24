package com.sucit.afm.service;

import com.sucit.afm.entity.Dispositivo;

import java.util.List;

public interface DispositivoService {

    public List<Dispositivo> listarTodos();

    public Dispositivo acharPorId(int id);

    public void salvar(Dispositivo dispositivo);

    public void deletarPorId(int id);
}
