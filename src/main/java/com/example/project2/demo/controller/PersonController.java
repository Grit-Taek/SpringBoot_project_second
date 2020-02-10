package com.example.project2.demo.controller;


import com.example.project2.demo.controller.dto.PersonDto;
import com.example.project2.demo.domain.Person;
import com.example.project2.demo.repository.PersonRepository;
import com.example.project2.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPerson( @PathVariable  Long id)
    {
        return personService.getPerson(id);
    }

    @PostMapping
    public void postPerson(@RequestBody Person person) {

        personService.put(person);
        log.info("person -> {} " , personRepository.findAll());
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable Long id , @RequestBody PersonDto personDto)
    {
        personService.modify(id , personDto);
        log.info("person -> {} " , personRepository.findAll());
    }

    @PatchMapping("/{id}")
    public void modifyPerson(@PathVariable Long id , String name)
    {
        personService.modify(id , name);
        log.info("person -> {} " , personRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id)
    {
        personService.delete(id);
        log.info("deleted person -> {} " , personRepository.findPeopleDeleted());
    }
}
