package ru.matrosov.rentauto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.matrosov.rentauto.models.Car;

import java.util.List;

@Component
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() {
        return jdbcTemplate.query("SELECT * FROM car", new BeanPropertyRowMapper<>(Car.class));
    }

    public void save(Car car) {
        jdbcTemplate.update("INSERT INTO Car(modelname, licenseplate) VALUES(?,?)", car.getModelName(), car.getLicensePlate());
    }
}
