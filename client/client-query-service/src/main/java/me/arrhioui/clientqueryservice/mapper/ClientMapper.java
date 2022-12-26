package me.arrhioui.clientqueryservice.mapper;

import me.arrhioui.clientqueryservice.entity.Client;
import me.arrhioui.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client from(ClientDTO clientDTO);
    ClientDTO from(Client client);
}
