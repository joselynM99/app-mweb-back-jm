package com.tesis.inventario.repo;

import com.tesis.inventario.db.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Integer> {
}
