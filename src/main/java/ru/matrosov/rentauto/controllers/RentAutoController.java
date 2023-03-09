package ru.matrosov.rentauto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.matrosov.rentauto.dao.PersonDAO;
import ru.matrosov.rentauto.models.Car;
import ru.matrosov.rentauto.models.Person;
import ru.matrosov.rentauto.dao.CarDAO;

@Controller
public class RentAutoController {


    private final PersonDAO personDAO;
    private final CarDAO carDAO;

    @Autowired
    public RentAutoController(PersonDAO personDAO, CarDAO carDAO) {
        this.personDAO = personDAO;
        this.carDAO = carDAO;
    }

    @GetMapping("/")
    public String test() {
        return "startPage";
    }

    @GetMapping("/people")
    public String peopleList(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/peopleList";
    }

    @GetMapping("/people/{id}")
    public String showPeople(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/people/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/editPerson";
    }

    @PatchMapping("/people/{id}/edit")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @GetMapping("/people/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/newPerson";
    }

    @PostMapping("/people")
    public String createPerson(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}/delete")
    public String deletePerson(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

    //////
    //CARS START HERE
    //////

    @GetMapping("/cars")
    public String carsList(Model model) {
        carDAO.index().stream().forEach(System.out::println);
        model.addAttribute("cars", carDAO.index());
        return "cars/carsList";
    }

    @GetMapping("/cars/new")
    public String newCar(@ModelAttribute("car") Car car) {
        return "cars/newCar";
    }

    @PostMapping("/cars")
    public String createCar(@ModelAttribute("car") Car car) {
        carDAO.save(car);
        return "redirect:/cars";
    }

}
