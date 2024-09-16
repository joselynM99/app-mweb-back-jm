package com.mweb.transacciones.repo;

import com.mweb.transacciones.db.Compra;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CompraRepository implements PanacheRepositoryBase<Compra, Integer> {
}
