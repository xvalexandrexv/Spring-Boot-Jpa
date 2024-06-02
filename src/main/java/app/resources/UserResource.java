package app.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // para dizer que esta classe é um recurso web que é implementado por um controlador REST
@RequestMapping(value = "/users") // isto para da o nome
public class UserResource {

    // agora para testar se esta funcionando vou criar um metodo que sera um end point para acessar aos users
    @GetMapping // para dizer este vai ser um metedo que responde a um pedido get do http é so colocar a anotaçao @GetMapping
    public ResponseEntity<User> findAll() { // o response entity e um tipo especifico so spring gera respostas de requisiçoes web
        User u = new User(1L, "Maria", "maria@gmail.com", "924400", "nikita");
        return ResponseEntity.ok().body(u);
    }
}
