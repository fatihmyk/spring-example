package com.fatihmayuk.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fatihmayuk.graphql.entity.Vehicle;
import com.fatihmayuk.graphql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    public final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type){

       return vehicleRepository.getByTypeLike(type);

    }

    public Optional<Vehicle> getById(Long id) {

        return vehicleRepository.findById(id);

    }
}
