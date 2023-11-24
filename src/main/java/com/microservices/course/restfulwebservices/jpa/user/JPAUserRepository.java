package com.microservices.course.restfulwebservices.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepository extends JpaRepository<JPAUser, Integer> {

}
