package me.arrhioui.orderqueryservice.repository;

import me.arrhioui.orderqueryservice.entity.Client;
import me.arrhioui.orderqueryservice.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, String> {
}
