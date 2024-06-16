package app.resources.services;

import app.resources.model.User;
import app.resources.repository.UserRepository;
import app.resources.services.exceptions.DataBaseException;
import app.resources.services.exceptions.ResourceNotFoundExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundExecption(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public User findByName(String name) {
        return repository.findByName(name);

    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundExecption(id);
        } catch (DataIntegrityViolationException e ) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) { // primeiro apanho o user atraves do seu ID depois
        // modifico atraves do obj.

        User entity = repository.getReferenceById(id); // diferente do findById na linha 23 ele so prepara o obj
        // para ser utilizado o repository.findById() tras diretamente o obj de banco de dados.
        updatedData(entity, obj);
        return repository.save(entity);
    }

    private void updatedData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
