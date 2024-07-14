package com.mweb.ventas.repo;

import com.mweb.ventas.db.DetalleVenta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DetalleVentaRepository implements PanacheRepositoryBase<DetalleVenta, Integer> {
}
