package app.resources.repository;

import app.resources.model.Category;
import app.resources.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // isto e para registrar
public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{


}
