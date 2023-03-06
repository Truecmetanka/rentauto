package ru.matrosov.rentauto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.matrosov.rentauto.dao.PersonDAO;

@Controller
public class RentAutoController {


    private final PersonDAO personDAO;

    @Autowired
    public RentAutoController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/hello")
    public String test(Model model) {
        model.addAttribute("key", "Hello");
        return "hello";
    }

    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
