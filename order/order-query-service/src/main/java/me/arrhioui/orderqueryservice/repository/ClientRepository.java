package me.arrhioui.orderqueryservice.repository;

import me.arrhioui.orderqueryservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
