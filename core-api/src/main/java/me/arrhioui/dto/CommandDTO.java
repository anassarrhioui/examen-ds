package me.arrhioui.dto;

import me.arrhioui.enums.CommandsState;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommandDTO {
    private String id;
    private Instant dateCommande;
    private Instant dateLivraison;
    private CommandsState commandsState;
    private ClientDTO client;
    private List<LigneCommandDTO> ligneCommands = new ArrayList<>();
}
