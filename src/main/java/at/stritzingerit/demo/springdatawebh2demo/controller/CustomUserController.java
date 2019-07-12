package at.stritzingerit.demo.springdatawebh2demo.controller;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import at.stritzingerit.demo.springdatawebh2demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RepositoryRestController
public class CustomUserController {

    private final UserRepository repository;

    @Autowired
    public CustomUserController(UserRepository repo) {
        repository = repo;
    }

    @RequestMapping(method = GET, value = "/users/search/customSearch")
    public @ResponseBody
    ResponseEntity<?> getProducers() {
        List<User> producers = (List<User>) repository.findAll();

        Resources<User> resources = new Resources<User>(producers);
        resources.add(linkTo(methodOn(CustomUserController.class).getProducers()).withSelfRel());

        return ResponseEntity.ok(resources);
    }
}
