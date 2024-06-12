package app.resources.repository;

import app.resources.model.Category;
import app.resources.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // isto e para registrar
public interface CategoryRepository extends JpaRepository <Category, Long>{


}
