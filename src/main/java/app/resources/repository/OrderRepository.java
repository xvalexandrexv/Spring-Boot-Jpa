package app.resources.repository;

import app.resources.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // isto e para registrar
public interface OrderRepository extends JpaRepository <Order, Long>{


}
