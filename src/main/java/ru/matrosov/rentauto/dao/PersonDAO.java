package ru.matrosov.rentauto.dao;

import org.springframework.stereotype.Component;
import ru.matrosov.rentauto.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people.add(new Person(1,19, "Danil", "Danil@mail.ru"));
        people.add(new Person(2, 20, "Sasha", "Sasha@mail.ru"));
        people.add(new Person(3, 20, "Egor", "Egor@mail.ru"));
        people.add(new Person(4, 19, "Nikita", "Nikita@mail.ru"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
