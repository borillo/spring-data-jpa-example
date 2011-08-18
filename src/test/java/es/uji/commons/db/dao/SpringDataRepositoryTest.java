package es.uji.commons.db.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.apache.commons.collections15.IteratorUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.expr.BooleanExpression;

import es.uji.commons.db.model.QUsuario;
import es.uji.commons.db.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class SpringDataRepositoryTest
{
    private static final String USUARIO_NOMBRE = "Pedro";
    private static final String USUARIO_PRIMER_APELLIDO = "Perez";

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    @Before
    public void init()
    {
        usuario = new Usuario();
        usuario.setNombre(USUARIO_NOMBRE);
        usuario.setPrimerApellido(USUARIO_PRIMER_APELLIDO);
        usuario = usuarioRepository.save(usuario);
    }

    @Test
    public void metodoGenericoDeRecuperacionBySpringData()
    {
        Usuario dbUser = usuarioRepository.findOne(usuario.getId());

        assertThat(dbUser, is(notNullValue()));
    }

    @Test
    public void metodoDefinidoYAutoimplementadoBySpringData()
    {
        List<Usuario> users = usuarioRepository.findByPrimerApellido(USUARIO_PRIMER_APELLIDO);

        assertThat(users, is(notNullValue()));
        assertThat(users, hasItem(usuario));
    }

    @Test
    public void namedQueryEnLaEntidadJPA()
    {
        Usuario reference = usuarioRepository.findByElNombreDelUsuario(USUARIO_NOMBRE);

        assertThat(usuario, equalTo(reference));
    }

    @Test
    public void metodoImplementadoEnElInterfazExtendido()
    {
        List<Usuario> users = usuarioRepository.metodoInterfazExtendido();

        assertThat(users, is(notNullValue()));
        assertThat(users, hasItem(usuario));
    }

    @Test
    public void consultaConSpecificationEnQueryDSL()
    {
        QUsuario dbUser = QUsuario.usuario;
        BooleanExpression condicion = dbUser.nombre.eq("Pedro").or(dbUser.nombre.eq("Juan"));

        Iterable<Usuario> queryResult = usuarioRepository.findAll(condicion);
        List<Usuario> users = IteratorUtils.toList(queryResult.iterator());

        assertThat(users, is(notNullValue()));
        assertThat(users, hasItem(usuario));
    }
}