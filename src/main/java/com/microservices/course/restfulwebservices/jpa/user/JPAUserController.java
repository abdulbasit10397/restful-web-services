package com.microservices.course.restfulwebservices.jpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JPAUserController {

    @Autowired
    private JPAUserRepository jpaUserRepository;

    @GetMapping(path = "/jpa/users")
    public List<JPAUser> getAllJpaUsers() {
        return jpaUserRepository.findAll();
    }

    @GetMapping(path = "/jpa/user/{id}")
    public JPAUser getJpaUser(@PathVariable int id) {
        Optional<JPAUser> JPAUser = jpaUserRepository.findById(id);
        if (!JPAUser.isPresent())
            throw new JPAUserNotFoundException("id-" + id);

        return JPAUser.get();
    }

    @PostMapping(path = "/jpa/users/save")
    public JPAUser saveJpaUser(@RequestBody JPAUser JPAUser) {
        return jpaUserRepository.save(JPAUser);
    }

    @DeleteMapping(path = "/jpa/user/{id}")
    public void deleteJpaUser(@PathVariable int id) {
        jpaUserRepository.deleteById(id);
    }
}
