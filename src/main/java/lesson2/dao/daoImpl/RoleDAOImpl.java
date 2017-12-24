package lesson2.dao.daoImpl;

import lesson2.config.Database;
import lesson2.dao.RoleDAO;
import lesson2.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private static final String INSER_ROLE = "INSERT INTO roles(name) VALUES (?)";
    private static final String UPDATE_ROLE = "UPDATE roles SET name = ? WHERE id = ?";
    private static final String DELL_ROLE = "DELETE FROM roles WHERE id = ?";

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setName(resultSet.getString("name"));
                role.setId(resultSet.getInt("id"));
                roleList.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public void create(Role role) {
        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSER_ROLE)) {
            preparedStatement.setString(1, role.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE)) {
            preparedStatement.setString(1, role.getName());
            preparedStatement.setInt(2, role.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELL_ROLE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
