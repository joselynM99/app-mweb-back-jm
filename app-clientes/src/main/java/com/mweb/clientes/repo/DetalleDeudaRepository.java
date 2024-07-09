package com.mweb.clientes.repo;

import com.mweb.clientes.db.DetalleDeuda;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DetalleDeudaRepository implements PanacheRepositoryBase<DetalleDeuda, Integer> {
}
