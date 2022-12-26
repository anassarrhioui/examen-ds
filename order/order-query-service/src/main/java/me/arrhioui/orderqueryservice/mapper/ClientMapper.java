package me.arrhioui.orderqueryservice.mapper;

import me.arrhioui.dto.ClientDTO;
import me.arrhioui.orderqueryservice.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client from(ClientDTO clientDTO);
    ClientDTO from(Client client);
}
