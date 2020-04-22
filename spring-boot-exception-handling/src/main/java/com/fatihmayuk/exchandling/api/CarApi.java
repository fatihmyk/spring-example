package com.fatihmayuk.exchandling.api;

import com.fatihmayuk.exchandling.dto.Car;
import com.fatihmayuk.exchandling.exception.EntityNotFoundException;
import com.fatihmayuk.exchandling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){

        return ResponseEntity.ok(carService.getCar(name));
    }

    /*@ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound(){

        return "Record not found";
    }*/
}
