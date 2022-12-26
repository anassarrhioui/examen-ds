package me.arrhioui.event;

import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ClientDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategorieCreatedEvent {
    private CategorieDTO categorieDTO;
}
