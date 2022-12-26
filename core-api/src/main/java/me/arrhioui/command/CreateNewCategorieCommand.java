package me.arrhioui.command;


import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ClientDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewCategorieCommand {
    private CategorieDTO categorieDTO;
}
