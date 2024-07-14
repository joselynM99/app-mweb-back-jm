package com.mweb.ventas.repo;

import com.mweb.ventas.db.Venta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VentaRepository implements PanacheRepositoryBase<Venta, Integer> {
}
