package com.sucit.afm.dao;

import com.sucit.afm.entity.DispositivoPessoal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;
@Repository
public class DispositivoPessoalDAOImpl implements DispositivoPessoalDAO{

    private final EntityManager em;

    @Autowired
    public DispositivoPessoalDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DispositivoPessoal> listarTodos() {
        Session s = em.unwrap(Session.class);

        Query<DispositivoPessoal> q =
                s.createQuery("from DispositivoPessoal" , DispositivoPessoal.class);

        return q.getResultList();
    }

    @Override
    public DispositivoPessoal acharPorId(int id) {
        Session s = em.unwrap(Session.class);

        return s.find(DispositivoPessoal.class , id);
    }

    @Override
    public void salvar(DispositivoPessoal dispositivoPessoal) {
        Session s = em.unwrap(Session.class);
        s.saveOrUpdate(dispositivoPessoal);
    }

    @Override
    public void deletarPorId(int id) {
        Session s = em.unwrap(Session.class);
        DispositivoPessoal d1 = s.find(DispositivoPessoal.class, id);
        s.remove(d1);
    }
}
