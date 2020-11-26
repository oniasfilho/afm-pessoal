package com.sucit.afm.dao;

import com.sucit.afm.entity.Dispositivo;
import com.sucit.afm.entity.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> listarTodos();

    public Usuario acharPorId(int id);

    public void salvar(Usuario usuario);

    public void deletarPorId(int id);
}
