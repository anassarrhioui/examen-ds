package me.arrhioui.produitqueryservice.repository;

import me.arrhioui.produitqueryservice.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, String> {
}
