package lesson2.demo;

import lesson2.config.Database;
import lesson2.model.Laptop;
import lesson2.model.Role;
import lesson2.model.TShirt;
import lesson2.model.User;
import lesson2.service.LaptopService;
import lesson2.service.serviceImpl.LaptopServiceImpl;
import lesson2.service.serviceImpl.RoleServiceImpl;
import lesson2.service.serviceImpl.TShirtServiceImpl;
import lesson2.service.serviceImpl.UserServiceImpl;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

//        @Cleanup
//        Connection connection = Database.getConnection();

//        @Cleanup
//        Statement statement = connection.createStatement();

//        statement.execute("INSERT INTO miracle.users (name, skills) VALUES ('Test', 'test test')");

//        statement.executeUpdate("UPDATE miracle.users SET name='Tratata' WHERE id=5");

//        statement.executeUpdate("DELETE FROM miracle.users WHERE id=5");

//        UserServiceImpl userService = new UserServiceImpl();
//        List<User> allUser = userService.getAllUser();

//        for (User elem : allUser) {
//            System.out.println(elem);
//        }
//
//        User user = new User();
//        user.setName("Valentina");
//        user.setSkills("C");

//        userService.create(user);

//        userService.update(user);

//        userService.delete(6);

//        TShirtServiceImpl tShirtService = new TShirtServiceImpl();
//        List<TShirt> allTShirts = tShirtService.getAllTShirts();

//        TShirt tShirt = new TShirt();
//        tShirt.setSize("Xs");
//        tShirt.setColor("Green");
//        tShirtService.update(tShirt);
//        tShirtService.create(tShirt);
//        tShirtService.delete(4);
//        for (TShirt elem : allTShirts) {
//            System.out.println(elem);
//
//        RoleServiceImpl roleService = new RoleServiceImpl();
//        List<Role> allRoles = roleService.getAllRoles();
//        Role role1 = new Role();
//        role1.setName("MODERATOR");
//        role1.setId(3);
//        roleService.create(role1);
//        roleService.update(role1);
//        roleService.delete(3);
//
//        for (Role role : allRoles) {
//            System.out.println(role);
//        }

        LaptopService service = new LaptopServiceImpl();
        List<Laptop> allLaptop = service.getAllLaptop();

        Laptop laptop1 = new Laptop();
        laptop1.setId(6);
        laptop1.setUserId(3);
        laptop1.setName("Macintoch");
//        service.create(laptop1);
//        service.update(laptop1);
//        service.delete(6);

        for (Laptop laptop : allLaptop) {
            System.out.println(laptop);
        }
    }
}
