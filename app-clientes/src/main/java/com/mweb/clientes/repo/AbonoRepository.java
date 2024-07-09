package com.mweb.clientes.repo;

import com.mweb.clientes.db.Abono;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AbonoRepository implements PanacheRepositoryBase<Abono, Integer> {
}
