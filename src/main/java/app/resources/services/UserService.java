package app.resources.services;

import app.resources.model.User;
import app.resources.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // esta registado no spring como um componente de serviço
public class UserService {

    // o user serviçe vai ter uma dependencia para o repositorio para apanhar os usuarios
    @Autowired // para fazer dependencia com o userRepository e assim responder ao pedido GET
    private UserRepository repository;

    public List<User> findAll() { // fizemos uma operaçao na camada de serviço que repassa para o repository.findall
       return repository.findAll(); // este find all como podemos ver e da base de dados
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        if(obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    public User findByName(String name) {
         return repository.findByName(name);

    }

    public User createUser(User user) {
        return repository.save(user);
    }
}
