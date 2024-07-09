package com.mweb.inventario.repo;

import com.mweb.inventario.db.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoRepository  implements PanacheRepositoryBase<Producto, Integer> {
}
