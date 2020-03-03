package com.fatihmayuk.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fatihmayuk.graphql.dto.VehicleDto;
import com.fatihmayuk.graphql.entity.Vehicle;
import com.fatihmayuk.graphql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;


    public Vehicle createVehicle(VehicleDto vehicleDto){
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        vehicle.setLaunchDate(new Date());

        return vehicle;

    }
}
