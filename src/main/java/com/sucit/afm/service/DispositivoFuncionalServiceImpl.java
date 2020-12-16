package com.sucit.afm.service;

import com.sucit.afm.dao.DispositivoFuncionalDAO;
import com.sucit.afm.entity.DispositivoFuncional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DispositivoFuncionalServiceImpl implements DispositivoFuncionalService {

    DispositivoFuncionalDAO dao;

    public DispositivoFuncionalServiceImpl(DispositivoFuncionalDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<DispositivoFuncional> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    @Transactional
    public DispositivoFuncional acharPorId(int id) {
        return dao.acharPorId(id);
    }

    @Override
    @Transactional
    public void salvar(DispositivoFuncional dispositivoFuncional) {
        dao.salvar(dispositivoFuncional);
    }

    @Override
    @Transactional
    public void deletarPorId(int id) {
        dao.deletarPorId(id);
    }
}
