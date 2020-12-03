package com.sucit.afm.dao;

import com.sucit.afm.entity.Dispositivo;
import com.sucit.afm.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private EntityManager em;

    @Autowired
    public UsuarioDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Usuario> listarTodos() {
        Session s = em.unwrap(Session.class);

        Query<Usuario> q =
                s.createQuery("from Usuario", Usuario.class);

        return q.getResultList();
    }

    @Override
    public Usuario acharPorId(int id) {
        Session s = em.unwrap(Session.class);

        return s.find(Usuario.class, id);
    }

    @Override
    public void salvar(Usuario usuario) {
        Session s = em.unwrap(Session.class);


        s.saveOrUpdate(usuario);
    }

    @Override
    public void deletarPorId(int id) {
        Session s = em.unwrap(Session.class);

        Usuario u1 = s.find(Usuario.class, id);

        s.delete(u1);

    }
}
