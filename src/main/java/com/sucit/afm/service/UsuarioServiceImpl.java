package com.sucit.afm.service;

import com.sucit.afm.dao.UsuarioDAO;
import com.sucit.afm.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioDAO dao;

    @Autowired
    public UsuarioServiceImpl(UsuarioDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Usuario> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public Usuario acharPorId(int id) {
        return dao.acharPorId(id);
    }

    @Override
    public void salvar(Usuario usuario) {
        dao.salvar(usuario);
    }

    @Override
    public void deletarPorId(int id) {
        dao.deletarPorId(id);
    }
}
