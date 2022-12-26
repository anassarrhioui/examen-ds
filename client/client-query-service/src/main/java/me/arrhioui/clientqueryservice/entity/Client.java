package me.arrhioui.clientqueryservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Client {
    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
