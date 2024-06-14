package app.resources.repository;

import app.resources.model.Category;
import app.resources.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // isto e para registrar
public interface ProductRepository extends JpaRepository <Product, Long>{


}
