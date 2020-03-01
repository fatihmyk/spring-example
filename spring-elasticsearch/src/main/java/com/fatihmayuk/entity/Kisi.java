package com.fatihmayuk.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "kisiler", type = "kisi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Kisi {

    @Id
    private String id;

    @Field(name = "ad", type = FieldType.Text)
    private String ad;

    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;

    @Field(name = "adres", type = FieldType.Text)
    private String adres;

    @Field(name = "dogum_tarihi", type = FieldType.Date)
    private Date dogumTarihi;


}
