package com.mweb.compras.repo;

import com.mweb.compras.db.DetalleCompra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DetalleCompraRepository implements PanacheRepositoryBase<DetalleCompra, Integer> {
}
