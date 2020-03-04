package com.fatihmayuk.rc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KisiDto {

    private Long id;

    private String adi;

    private String soyadi;

    private List<String> adresler;

}
