package com.example.demo.person;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(
            @PathVariable("id") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        personService.updatePerson(personId, name, email);
    }
}
