package com.fatihmayuk.graphql.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vehicle_type", length = 100)
    private String type;

    @Column(name = "model_code", length = 100)
    private String modelCode;

    @Column(name = "brand_name", length = 100)
    private String brandName;

    @Column(name = "launch_date")
    private Date launchDate;
}
