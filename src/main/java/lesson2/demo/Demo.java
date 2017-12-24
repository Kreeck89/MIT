package lesson2.demo;

import lesson2.config.Database;
import lesson2.model.User;
import lesson2.service.serviceImpl.UserServiceImpl;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

        @Cleanup
        Connection connection = Database.getConnection();

        @Cleanup
        Statement statement = connection.createStatement();

//        statement.execute("INSERT INTO miracle.users (name, skills) VALUES ('Test', 'test test')");

//        statement.executeUpdate("UPDATE miracle.users SET name='Tratata' WHERE id=5");

//        statement.executeUpdate("DELETE FROM miracle.users WHERE id=5");

        UserServiceImpl userService = new UserServiceImpl();
        List<User> allUser = userService.getAllUser();

        User user = new User();
        user.setName("Petro");
        user.setSkills("C#");
        user.setId(3);

//        userService.create(user);

        userService.update(user);
    }

}
