package com.sucit.afm.dao;

import com.sucit.afm.entity.Dispositivo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class DispositivoDAOImpl implements DispositivoDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Dispositivo> listarTodos() {
        Session s = entityManager.unwrap(Session.class);

        Query<Dispositivo> q =
                s.createQuery("from Dispositivo", Dispositivo.class);

        return q.getResultList();
    }

    @Override
    public Dispositivo acharPorId(int id) {
        Session s = entityManager.unwrap(Session.class);

        return s.get(Dispositivo.class, id);
    }

    @Override
    public void salvar(Dispositivo dispositivo) {
        Session s = entityManager.unwrap(Session.class);
        s.saveOrUpdate(dispositivo);
    }

    @Override
    public void deletarPorId(int id) {
        Session s = entityManager.unwrap(Session.class);

        Dispositivo d1 = s.get(Dispositivo.class, id);
        s.delete(d1);
    }
}
