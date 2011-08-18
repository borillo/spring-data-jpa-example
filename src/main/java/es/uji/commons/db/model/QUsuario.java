package es.uji.commons.db.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = 1071674009;

    public static final QUsuario usuario = new QUsuario("usuario");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nombre = createString("nombre");

    public final StringPath primerApellido = createString("primerApellido");

    public QUsuario(String variable) {
        super(Usuario.class, forVariable(variable));
    }

    public QUsuario(BeanPath<? extends Usuario> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUsuario(PathMetadata<?> metadata) {
        super(Usuario.class, metadata);
    }

}

