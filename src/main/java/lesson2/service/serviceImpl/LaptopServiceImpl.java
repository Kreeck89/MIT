package lesson2.service.serviceImpl;

import lesson2.dao.daoImpl.LaptopDAOImpl;
import lesson2.model.Laptop;
import lesson2.service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    @Override
    public List<Laptop> getAllLaptop() {
        return new LaptopDAOImpl().getAllLaptop();
    }

    @Override
    public void create(Laptop laptop) {
        new LaptopDAOImpl().create(laptop);
    }

    @Override
    public void update(Laptop laptop) {
        new LaptopDAOImpl().update(laptop);
    }

    @Override
    public void delete(int id) {
        new LaptopDAOImpl().delete(id);
    }
}
