package com.mweb.negocios.repo;

import com.mweb.negocios.db.Rol;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class RolRepository implements PanacheRepositoryBase<Rol, Integer> {
}
