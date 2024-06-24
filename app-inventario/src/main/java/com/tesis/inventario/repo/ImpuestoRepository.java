package com.tesis.inventario.repo;

import com.tesis.inventario.db.Impuesto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ImpuestoRepository implements PanacheRepositoryBase<Impuesto, Integer> {
}
