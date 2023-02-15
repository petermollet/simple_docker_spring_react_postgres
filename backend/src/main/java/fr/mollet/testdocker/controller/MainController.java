package fr.mollet.testdocker.controller;

import fr.mollet.testdocker.model.Person;
import fr.mollet.testdocker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    private final PersonRepository personRepository;

    @GetMapping("/hello")
    public String hello() {
        List<Person> people = personRepository.findAll();
        if(people.isEmpty()) {
            return "Hello World!";
        } else {
            return "Hello " + people.get(0).getName() + "!";
        }
    }
}
