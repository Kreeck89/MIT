package lesson2.dao;

import lesson2.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();
    void update(User user);
    void delete(int id);
    void create(User user);
}
