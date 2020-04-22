package com.fatihmayuk.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class KisiDto {

    private Long id;

    @NotNull
    private String adi;

    private String soyadi;

    private List<String> adresler;
}
