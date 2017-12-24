package lesson2.service.serviceImpl;

import lesson2.config.Database;
import lesson2.model.User;
import lesson2.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final String INSERT_USER = "INSERT INTO miracle.users(name, skills) VALUES (?,?)";
    private static final String UPDATE_USER = "UPDATE  miracle.users SET name = ?, skills = ? WHERE id = ?";

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from miracle.users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSkills(resultSet.getString("skills"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(User user) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
