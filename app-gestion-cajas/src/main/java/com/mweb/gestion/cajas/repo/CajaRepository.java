package com.mweb.gestion.cajas.repo;

import com.mweb.gestion.cajas.db.Caja;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CajaRepository implements PanacheRepositoryBase<Caja, Integer> {
}
