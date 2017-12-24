package lesson2.dao;

import lesson2.model.TShirt;

import java.util.List;

public interface TShirtDAO {

    List<TShirt> getAllTShirts();
    void update(TShirt tShirt);
    void create(TShirt tShirt);
    void delete(int id);
}
