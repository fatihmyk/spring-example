package com.fatihmayuk;

import com.fatihmayuk.entity.Car;
import com.fatihmayuk.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HazelcastApplication {

    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(HazelcastApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void generateDefaultData() {
        Long count = carRepository.count();
        if (count == 0L) {
            List<String> colors = List.of("Black", "White", "Red", "Blue");
            List<Car> carList = new ArrayList<>();
            Date newDate = new Date();
            for (int i = 0; i < 500; i++) {
                carList.add(
                        Car.builder()
                                .brand("HKCar")
                                .colour(colors.get(i % 3))
                                .date(newDate)
                                .doorCount(4)
                                .fuel("Diesel")
                                .model("SuperCar")
                                .serial("SR" + i)
                                .type("TypeC")
                                .year(2020)
                                .build()
                );
            }
            carRepository.saveAll(carList);
        }
    }
}
