package com.tinkoff.education.service;

import com.tinkoff.education.domain.Car;
import com.tinkoff.education.repository.CarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            return carRepository.save(car);
        }
        return null;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
