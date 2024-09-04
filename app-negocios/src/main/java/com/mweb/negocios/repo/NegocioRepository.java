package com.mweb.negocios.repo;

import com.mweb.negocios.db.Negocio;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class NegocioRepository implements PanacheRepositoryBase<Negocio, Integer> {

}
