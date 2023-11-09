package com.arnovandijck.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Arno", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Jeroen",  LocalDate.now().minusYears(27)));
        users.add(new User(3, "Joris",  LocalDate.now().minusYears(45)));
    }


    public List<User> findAll() {
        return users;
    }

    public void save (User user) {
        if (user.getId() == null) {
            user.setId(users.size() + 1);
        }
        users.add(user);
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

}
