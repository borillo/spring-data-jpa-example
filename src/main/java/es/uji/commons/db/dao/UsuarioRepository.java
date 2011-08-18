package es.uji.commons.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import es.uji.commons.db.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>,
        QueryDslPredicateExecutor<Usuario>, UsuarioRepositoryExtension
{
    public Usuario findByElNombreDelUsuario(String nombre);

    public List<Usuario> findByPrimerApellido(String primerApellido);

    @Query("select u from Usuario u where u.primerApellido = ?")
    public List<Usuario> findByPrimerApellidoConNamedQuery(String primerApellido);
}
