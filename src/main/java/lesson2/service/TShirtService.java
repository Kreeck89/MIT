package lesson2.service;

import lesson2.model.TShirt;

import java.util.List;

public interface TShirtService {

    List<TShirt> getAllTShirts();
    void update(TShirt tShirt);
    void create(TShirt tShirt);
    void delete(int id);
}
