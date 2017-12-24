package lesson2.service.serviceImpl;

import lesson2.config.Database;
import lesson2.dao.UserDAO;
import lesson2.dao.daoImpl.UserDAOImpl;
import lesson2.model.User;
import lesson2.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUser() {
        return new UserDAOImpl().getAllUser();
    }

    @Override
    public void update(User user) {
        new UserDAOImpl().update(user);
    }

    @Override
    public void delete(int id) {
        new UserDAOImpl().delete(id);
    }

    @Override
    public void create(User user) {
        new UserDAOImpl().create(user);
    }
}
