package me.arrhioui.event;

import lombok.*;
import me.arrhioui.dto.ClientDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientCreatedEvent {
    private ClientDTO clientDTO;
}
