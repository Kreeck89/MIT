package lesson2.dao.daoImpl;

import lesson2.config.Database;
import lesson2.dao.LaptopDAO;
import lesson2.model.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAOImpl implements LaptopDAO {

    private static final String INSER_ROLE = "INSERT INTO laptops(name, userid) VALUES(?,?)";
    private static final String UPDATE_ROLE = "UPDATE laptops SET name =?, userid = ? WHERE id = ?";
    private static final String DELL_ROLE = "DELETE FROM laptops WHERE id = ?";

    @Override
    public List<Laptop> getAllLaptop() {
        List<Laptop> listOfLaptop = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM laptops");
            while (resultSet.next()) {
                Laptop laptop = new Laptop();
                connection.setAutoCommit(false);
                laptop.setId(resultSet.getInt("id"));
                laptop.setName(resultSet.getString("name"));
                laptop.setUserId(resultSet.getInt("userId"));
                connection.commit();
                listOfLaptop.add(laptop);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return listOfLaptop;
    }

    @Override
    public void create(Laptop laptop) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSER_ROLE)) {
            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setInt(2, laptop.getUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Laptop laptop) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE)) {
            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setInt(2, laptop.getUserId());
            preparedStatement.setInt(3, laptop.getId());
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
