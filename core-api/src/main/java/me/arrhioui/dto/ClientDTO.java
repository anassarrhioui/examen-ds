package me.arrhioui.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDTO {

        private String id;
        private String name;
        private String address;
        private String phone;
        private String email;
}
