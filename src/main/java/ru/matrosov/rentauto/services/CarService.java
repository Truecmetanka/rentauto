package ru.matrosov.rentauto.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.rentauto.models.Car;
import ru.matrosov.rentauto.repositories.CarRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
