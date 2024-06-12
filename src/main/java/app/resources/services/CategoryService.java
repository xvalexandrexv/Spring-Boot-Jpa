package app.resources.services;

import app.resources.model.Category;
import app.resources.model.Order;
import app.resources.repository.CategoryRepository;
import app.resources.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esta registado no spring como um componente de serviço
public class CategoryService {

    // O order service vai ter uma dependencia para o repositorio para apanhar os usuarios quando usamos
    // finfById ou outros tipos de serviço
    @Autowired // para fazer dependencia com o userRepository e assim responder ao pedido GET
    private CategoryRepository repository;

    public List<Category> findAll() { // fizemos uma operaçao na camada de serviço que repassa para o repository.findall
       return repository.findAll(); // este find all como podemos ver e da base de dados
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
