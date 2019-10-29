package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public ResponseEntity addPerson(@Valid @NotNull @RequestBody Person person){
       Person user= personService.addPerson(person);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id }").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(location).body(user);

    }

    @GetMapping
    public List<Person> getPeople(){
       return personService.getAllPeople();
    }
    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);

    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") UUID id){
        boolean wasDeleted=personService.deletePerson(id);
        if(wasDeleted)return ResponseEntity.status(200).body(null);
        return ResponseEntity.status(404).body("invalid id");

    }
    @PutMapping(path="/{id}")
    public Person updatePerson(@PathVariable("id") UUID id, @NotNull @Valid @RequestBody() Person person){
     return personService.updatePerson(id,person);
    }
}
