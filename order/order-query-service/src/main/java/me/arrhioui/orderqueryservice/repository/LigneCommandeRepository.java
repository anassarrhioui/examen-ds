package me.arrhioui.orderqueryservice.repository;

import me.arrhioui.orderqueryservice.entity.Commande;
import me.arrhioui.orderqueryservice.entity.LigneCommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommand, String> {
}
