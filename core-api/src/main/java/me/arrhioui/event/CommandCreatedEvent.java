package me.arrhioui.event;

import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.CommandDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommandCreatedEvent {
    private CommandDTO commandDTO;
}
