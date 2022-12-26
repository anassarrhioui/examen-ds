package me.arrhioui.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategorieDTO {
    private String id;
    private String name;
    private String description;
}
