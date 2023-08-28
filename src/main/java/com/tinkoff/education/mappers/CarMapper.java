package com.tinkoff.education.mappers;

import com.tinkoff.education.domain.Car;
import com.tinkoff.education.dto.CarDto;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {
    public CarDto carToCarDto(Car car){
        var carDto = new CarDto();
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setModel(car.getModel());
        return carDto;
    }

    public Car carDtoToCar(CarDto carDto){
        var car = new Car();
        car.setLicensePlate(carDto.getLicensePlate());
        car.setModel(carDto.getModel());
        return car;
    }
}
