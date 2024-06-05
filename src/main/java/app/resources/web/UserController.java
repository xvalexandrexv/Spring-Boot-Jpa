package app.resources.web;

import app.resources.model.User;
import app.resources.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // para dizer que esta classe é um recurso web que é implementado por um controlador REST
@RequestMapping(value = "/users") // isto para da o nome
public class UserController {

    @Autowired
    private UserService service; // este autowired estra dependente do UserService atravez da anotçao @Service

    // Agora para testar se esta funcionando vou criar um metodo que sera um end point para acessar aos users
    @GetMapping // para dizer este vai ser um metedo que responde a um pedido get do http é so colocar a anotaçao @GetMapping
    public ResponseEntity<List<User>> findAll() { // o response entity e um tipo especifico so spring gera respostas de requisiçoes web
        List<User> list = service.findAll(); // e este e para mostrar para o utlizador

        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}") // este Id se refere ao URL vai ser o argumento que vai ser passado como ID atravez da anotaçao PathVariable
    // la no Postman ou browser e so fazer o http://localhost:8080/users para os usuarios e http://localhost:8080/users/1 para
    // apahar o user com ID 1
    public ResponseEntity<User> findById(@PathVariable Long id){
       User obj = service.findById(id);
       return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<User> findByName(@PathVariable String name) {
        User obj = service.findByName(name);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }
}
