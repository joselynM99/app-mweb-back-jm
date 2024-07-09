package com.mweb.inventario.repo;

import com.mweb.inventario.db.Proveedor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProveedorRepository implements PanacheRepositoryBase<Proveedor, Integer> {
}
