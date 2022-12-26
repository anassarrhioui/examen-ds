package me.arrhioui.orderqueryservice.query;

import lombok.AllArgsConstructor;
import me.arrhioui.event.GetAllOrdersQuery;
import me.arrhioui.orderqueryservice.entity.Commande;
import me.arrhioui.orderqueryservice.repository.CommandeRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeQuery {

    private CommandeRepository commandeRepository;

    @QueryHandler
    public List<Commande> getAllCommand(GetAllOrdersQuery query){
        return commandeRepository.findAll();
    }
}
