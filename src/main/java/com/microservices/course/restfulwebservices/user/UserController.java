package com.microservices.course.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);

        EntityModel model = EntityModel.of(user);

        //HATEOAS feature to route to see all users
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping(path = "/users/save")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping(path = "/users/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);

        //To get uri of newly created user
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }
}
