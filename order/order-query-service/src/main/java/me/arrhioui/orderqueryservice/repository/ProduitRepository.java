package me.arrhioui.orderqueryservice.repository;

import me.arrhioui.orderqueryservice.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, String> {
}
