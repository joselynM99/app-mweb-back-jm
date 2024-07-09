package com.mweb.clientes.repo;

import com.mweb.clientes.db.Deuda;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DeudaRepository implements PanacheRepositoryBase<Deuda, Integer> {
}
