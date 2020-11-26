package com.sucit.afm.service;

import com.sucit.afm.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listarTodos();

    public Usuario acharPorId(int id);

    public void salvar(Usuario usuario);

    public void deletarPorId(int id);
}
