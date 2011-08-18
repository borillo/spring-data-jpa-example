package es.uji.commons.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uji.commons.db.model.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepositoryExtension
{
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> metodoInterfazExtendido()
    {
        return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
    }
}
