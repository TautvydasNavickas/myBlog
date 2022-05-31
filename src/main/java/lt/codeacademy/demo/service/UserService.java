package lt.codeacademy.demo.service;


import lt.codeacademy.demo.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
