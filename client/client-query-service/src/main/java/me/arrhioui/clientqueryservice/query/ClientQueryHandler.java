package me.arrhioui.clientqueryservice.query;

import lombok.AllArgsConstructor;
import me.arrhioui.clientqueryservice.entity.Client;
import me.arrhioui.clientqueryservice.mapper.ClientMapper;
import me.arrhioui.clientqueryservice.repository.ClientRepository;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.query.GetAllClientQuery;
import me.arrhioui.query.GetClientByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientQueryHandler {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @QueryHandler
    public List<ClientDTO> getAllClientsQH(GetAllClientQuery query){
        return clientRepository
                .findAll()
                .stream()
                .map(client -> clientMapper.from(client))
                .collect(Collectors.toList());
    }

    @QueryHandler
    public ClientDTO getClientByIdQH(GetClientByIdQuery query){
        Optional<Client> optionalClient = clientRepository.findById(query.getId());

        if(optionalClient.isPresent()){
            return clientMapper.from(optionalClient.get());
        }

        return null;
    }
}
