package lesson2.service;

import lesson2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    void update(User user);
    void delete(int id);
    void create(User user);
}
