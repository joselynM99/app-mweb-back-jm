package com.mweb.gestion.cajas.repo;

import com.mweb.gestion.cajas.db.CuadreCaja;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuadreCajaRepository implements PanacheRepositoryBase<CuadreCaja, Integer> {
}
