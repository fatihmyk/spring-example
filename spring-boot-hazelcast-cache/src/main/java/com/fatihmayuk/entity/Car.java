package com.fatihmayuk.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of={"id"})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Car implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_car", allocationSize = 1)
    @GeneratedValue(generator = "seq_car", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "serial_no")
    private String serial;

    @Column(length = 100, name = "model")
    private String model;

    @Column(length = 100, name = "brand")
    private String brand;

    @Column(name = "year")
    private Integer year;

    @Column(length = 100, name = "car_type")
    private String type;

    @Column(name = "door_count")
    private int doorCount;

    @Column(length = 100, name = "colour")
    private String colour;

    @Column(length = 100, name = "fuel")
    private String fuel;

    @Column(name = "reg_date")
    private Date date;
}
