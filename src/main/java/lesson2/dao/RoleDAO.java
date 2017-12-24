package lesson2.dao;

import lesson2.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAllRoles();
    void create(Role role);
    void update(Role role);
    void delete(int id);
}
