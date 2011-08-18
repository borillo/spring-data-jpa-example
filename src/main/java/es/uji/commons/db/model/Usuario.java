package es.uji.commons.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.domain.AbstractPersistable;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Usuario.findByElNombreDelUsuario", query = "from Usuario u where u.nombre = ?")
public class Usuario extends AbstractPersistable<Long>
{
    @Column(unique = true)
    private String nombre;
    private String primerApellido;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPrimerApellido()
    {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }
}