package com.microservices.course.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Abdul Basit", new Date()));
        users.add(new User(2, "Usama Ashraf", new Date()));
        users.add(new User(3, "Muhammad AbuBakr", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findOne(int userId) {
        for (User user : users) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public User deleteById(int userId) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext())
        {
            User user = iterator.next();
            if(user.getId() == userId)
            {
                iterator.remove();
                return user;
            }
        }

        return null;
    }


}
