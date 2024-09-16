package com.mweb.transacciones.repo;

import com.mweb.transacciones.db.Abono;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AbonoRepository implements PanacheRepositoryBase<Abono, Integer> {
}
