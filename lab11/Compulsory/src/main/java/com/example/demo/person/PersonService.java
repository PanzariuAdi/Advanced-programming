package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if (exists) {
            personRepository.deleteById(personId);
        }
    }

    @Transactional
    public void updatePerson(Long personId, String name, String email) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new IllegalStateException("Student with id " + personId + " does not exist !"));
        if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)) {
            person.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)) {
            person.setEmail(email);
        }
    }
}