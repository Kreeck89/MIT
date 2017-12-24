package lesson2.dao;

import lesson2.model.Laptop;

import java.util.List;

public interface LaptopDAO {

    List<Laptop> getAllLaptop();
    void create(Laptop laptop);
    void update(Laptop laptop);
    void delete(int id);
}
