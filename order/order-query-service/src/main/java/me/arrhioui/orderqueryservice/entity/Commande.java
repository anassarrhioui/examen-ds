package me.arrhioui.orderqueryservice.entity;

import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import me.arrhioui.enums.CommandsState;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Commande {
    @Id
    private String id;
    private Instant dateCommande;
    private Instant dateLivraison;

    @Enumerated(EnumType.STRING)
    private CommandsState commandsState;

    @ManyToOne
    private Client client;

    @OneToMany(fetch = FetchType.EAGER)
    private List<LigneCommand> ligneCommands = new ArrayList<>();
}
