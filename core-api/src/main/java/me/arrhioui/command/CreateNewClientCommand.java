package me.arrhioui.command;


import lombok.*;
import me.arrhioui.dto.ClientDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewClientCommand {
    private ClientDTO clientDTO;
}
