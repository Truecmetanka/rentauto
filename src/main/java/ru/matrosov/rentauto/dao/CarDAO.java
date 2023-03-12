package ru.matrosov.rentauto.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.matrosov.rentauto.models.Car;

import java.util.List;

@Component
public class CarDAO {
   // private final JdbcTemplate jdbcTemplate;

    private final SessionFactory sessionFactory;

    public CarDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Car> index() {
        Session session = sessionFactory.openSession();
        List<Car> cars = session.createQuery("from Car modelname", Car.class).getResultList();
        return cars;
    }

    @Transactional()
    public void save(Car car) {
        Session session = sessionFactory.openSession();
        session.persist(car);
    }
}
