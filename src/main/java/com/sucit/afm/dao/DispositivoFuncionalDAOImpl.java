package com.sucit.afm.dao;

import com.sucit.afm.entity.DispositivoFuncional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class DispositivoFuncionalDAOImpl implements DispositivoFuncionalDAO {

    private final EntityManager em;

    public DispositivoFuncionalDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DispositivoFuncional> listarTodos() {
        Session s = em.unwrap(Session.class);

        Query<DispositivoFuncional> q =
                s.createQuery("from DispositivoFuncional", DispositivoFuncional.class);

        return q.getResultList();
    }

    @Override
    public DispositivoFuncional acharPorId(int id) {
        Session s = em.unwrap(Session.class);

        return s.find(DispositivoFuncional.class, id);
    }

    @Override
    public void salvar(DispositivoFuncional dispositivoFuncional) {
        Session s = em.unwrap(Session.class);
        s.saveOrUpdate(dispositivoFuncional);
    }

    @Override
    public void deletarPorId(int id) {
        Session s = em.unwrap(Session.class);
        DispositivoFuncional df1 = s.find(DispositivoFuncional.class, id);
        s.remove(df1);
    }
}
