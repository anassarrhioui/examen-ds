package me.arrhioui.query;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetClientByIdQuery {
    private String id;
}
