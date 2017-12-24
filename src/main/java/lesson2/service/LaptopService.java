package lesson2.service;

import lesson2.model.Laptop;

import java.util.List;

public interface LaptopService {

    List<Laptop> getAllLaptop();
    void create(Laptop laptop);
    void update(Laptop laptop);
    void delete(int id);
}
