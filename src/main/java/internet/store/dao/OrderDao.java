package internet.store.dao;

import internet.store.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderDao {

    Order create(Order order);

    Optional<Order> get(Long id);

    List<Order> getUserOrders(Long userId);

    List<Order> getAll();

    Order update(Order order);

    boolean delete(Long id);
}