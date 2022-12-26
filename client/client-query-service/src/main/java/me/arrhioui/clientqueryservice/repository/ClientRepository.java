package me.arrhioui.clientqueryservice.repository;

import me.arrhioui.clientqueryservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
