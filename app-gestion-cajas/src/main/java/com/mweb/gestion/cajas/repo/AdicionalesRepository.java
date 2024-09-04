package com.mweb.gestion.cajas.repo;


import com.mweb.gestion.cajas.db.Adicionales;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AdicionalesRepository implements PanacheRepositoryBase<Adicionales, Integer> {
}
