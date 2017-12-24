package lesson2.service;

import lesson2.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    void create(Role role);
    void update(Role role);
    void delete(int id);
}
