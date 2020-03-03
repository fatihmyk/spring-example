package com.fatihmayuk.graphql.repository;

import com.fatihmayuk.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {


    List<Vehicle> getByTypeLike(String type);

    //List<Vehicle> getByModelCodeOrBrandName(String type);

}
