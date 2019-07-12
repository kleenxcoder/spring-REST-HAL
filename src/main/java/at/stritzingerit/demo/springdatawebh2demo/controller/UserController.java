package at.stritzingerit.demo.springdatawebh2demo.controller;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import at.stritzingerit.demo.springdatawebh2demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserRepository repository;

    @GetMapping("/")
    Iterable<User> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> one(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping("/")
    User create(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable Integer id) {
        return repository.save(user); //check if exists first ...
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

        @RequestMapping("/list")
    ResponseEntity<List<User>> getList(@RequestParam int page) {
        return ResponseEntity.ok(null);
    }

}
