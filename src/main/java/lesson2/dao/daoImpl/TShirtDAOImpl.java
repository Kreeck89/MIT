package lesson2.dao.daoImpl;

import lesson2.config.Database;
import lesson2.dao.TShirtDAO;
import lesson2.model.TShirt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TShirtDAOImpl implements TShirtDAO {

    private static final String UPDATE_TSHIRT = "UPDATE tshirts SET color = ?, size = ? WHERE id = ?";
    private static final String INSERT_TSHIRT = "INSERT INTO tshirts(color, size) VALUES (?, ?)";
    private static final String DELL_TSHIRT = "DELETE FROM tshirts WHERE id = ?";

    @Override
    public List<TShirt> getAllTShirts() {
        List<TShirt> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from tshirts");
            while (resultSet.next()) {
                TShirt tShirt = new TShirt();
                tShirt.setId(resultSet.getInt("id"));
                tShirt.setColor(resultSet.getString("color"));
                tShirt.setSize(resultSet.getString("size"));
                list.add(tShirt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(TShirt tShirt) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TSHIRT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, tShirt.getColor());
            preparedStatement.setString(2, tShirt.getSize());
            preparedStatement.setInt(3, tShirt.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(TShirt tShirt) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TSHIRT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, tShirt.getColor());
            preparedStatement.setString(2, tShirt.getSize());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELL_TSHIRT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
