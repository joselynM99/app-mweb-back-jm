package com.mweb.negocios.repo;

import com.mweb.negocios.db.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UsuarioRepository implements PanacheRepositoryBase<Usuario, Integer> {
}
