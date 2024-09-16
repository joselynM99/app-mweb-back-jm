package com.mweb.transacciones.repo;

import com.mweb.transacciones.db.Venta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VentaRepository implements PanacheRepositoryBase<Venta, Integer> {
}
