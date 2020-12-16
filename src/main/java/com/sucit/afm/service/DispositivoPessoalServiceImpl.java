package com.sucit.afm.service;

import com.sucit.afm.dao.DispositivoPessoalDAO;
import com.sucit.afm.entity.DispositivoPessoal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DispositivoPessoalServiceImpl implements DispositivoPessoalService {

    private DispositivoPessoalDAO dao;

    public DispositivoPessoalServiceImpl(DispositivoPessoalDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<DispositivoPessoal> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    @Transactional
    public DispositivoPessoal acharPorId(int id) {

        return dao.acharPorId(id);
    }

    @Override
    @Transactional
    public void salvar(DispositivoPessoal dispositivoPessoal) {
        dao.salvar(dispositivoPessoal);
    }

    @Override
    @Transactional
    public void deletarPorId(int id) {
        dao.deletarPorId(id);
    }
}
