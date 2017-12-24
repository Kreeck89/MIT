package lesson2.service.serviceImpl;

import lesson2.dao.daoImpl.RoleDAOImpl;
import lesson2.model.Role;
import lesson2.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> getAllRoles() {
        return new RoleDAOImpl().getAllRoles();
    }

    @Override
    public void create(Role role) {
        new RoleDAOImpl().create(role);
    }

    @Override
    public void update(Role role) {
        new RoleDAOImpl().update(role);
    }

    @Override
    public void delete(int id) {
        new RoleDAOImpl().delete(id);
    }
}
