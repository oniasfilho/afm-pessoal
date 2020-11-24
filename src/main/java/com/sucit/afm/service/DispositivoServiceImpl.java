package com.sucit.afm.service;

import com.sucit.afm.dao.DispositivoDAO;
import com.sucit.afm.entity.Dispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoDAO dao;

    @Override
    @Transactional
    public List<Dispositivo> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    @Transactional
    public Dispositivo acharPorId(int id) {
        return dao.acharPorId(id);
    }

    @Override
    @Transactional
    public void salvar(Dispositivo dispositivo) {
        dao.salvar(dispositivo);
    }

    @Override
    @Transactional
    public void deletarPorId(int id) {
        dao.deletarPorId(id);
    }
}
