package me.arrhioui.ordercommandservice.member;

import org.axonframework.modelling.command.EntityId;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientMember {
    @EntityId
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
