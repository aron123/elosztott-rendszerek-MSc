package hu.me.iit.osztott.redis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("person")
public class PersonController {
    private final PersonRepository personRepository;

    @PostMapping(consumes = "application/json")
    public void savePerson(@RequestBody @Valid PersonDto personDto) {
        personRepository.save(personDto.toPerson());
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable String id) {
        return new PersonDto(
                personRepository.findById(id).orElseThrow(EntityNotExistException::new));
    }
}
