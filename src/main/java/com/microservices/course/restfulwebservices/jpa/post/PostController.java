package com.microservices.course.restfulwebservices.jpa.post;

import com.microservices.course.restfulwebservices.jpa.user.JPAUser;
import com.microservices.course.restfulwebservices.jpa.user.JPAUserNotFoundException;
import com.microservices.course.restfulwebservices.jpa.user.JPAUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private JPAUserRepository jpaUserRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/jpa/posts")
    public List<Post> getAllJpaUsers() {
        return postRepository.findAll();
    }


    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> getUsersPosts(@PathVariable int id) {
        Optional<JPAUser> JPAUser = jpaUserRepository.findById(id);
        if (!JPAUser.isPresent())
            throw new JPAUserNotFoundException("id-" + id);

        return JPAUser.get().getPosts();
    }

    @PostMapping(path = "/jpa/users/{id}/posts/create")
    public Post createUsersPost(@PathVariable int id, @RequestBody Post userPost) {
        Optional<JPAUser> JPAUser = jpaUserRepository.findById(id);
        if (!JPAUser.isPresent())
            throw new JPAUserNotFoundException("id-" + id);

        userPost.setJpaUser(JPAUser.get());
        postRepository.save(userPost);

        return userPost;
    }
}
