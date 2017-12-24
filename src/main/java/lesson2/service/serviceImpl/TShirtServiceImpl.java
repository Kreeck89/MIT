package lesson2.service.serviceImpl;

import lesson2.dao.daoImpl.TShirtDAOImpl;
import lesson2.model.TShirt;
import lesson2.service.TShirtService;

import java.util.List;

public class TShirtServiceImpl implements TShirtService {
    @Override
    public List<TShirt> getAllTShirts() {
        return new TShirtDAOImpl().getAllTShirts();
    }

    @Override
    public void update(TShirt tShirt) {
        new TShirtDAOImpl().update(tShirt);
    }

    @Override
    public void create(TShirt tShirt) {
        new TShirtDAOImpl().create(tShirt);
    }

    @Override
    public void delete(int id) {
        new TShirtDAOImpl().delete(id);
    }
}
