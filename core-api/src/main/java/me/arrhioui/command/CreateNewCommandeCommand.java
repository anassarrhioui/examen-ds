package me.arrhioui.command;


import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.CommandDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewCommandeCommand {
    private CommandDTO commandDTO;
}
