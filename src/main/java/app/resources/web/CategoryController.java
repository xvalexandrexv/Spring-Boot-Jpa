package app.resources.web;

import app.resources.model.Category;
import app.resources.model.Order;
import app.resources.services.CategoryService;
import app.resources.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // para dizer que esta classe é um recurso web que é implementado por um controlador REST
@RequestMapping(value = "/categories") // isto para da o nome
public class CategoryController {

    @Autowired
    private CategoryService categoryService; // este autowired estra dependente do CategoryService atravez da anotçao @Service

    // Agora para testar se esta funcionando vou criar um metodo que sera um end point para acessar aos users
    @GetMapping // para dizer este vai ser um metedo que responde a um pedido get do http é so colocar a anotaçao @GetMapping
    public ResponseEntity<List<Category>> findAll() { // o response entity e um tipo especifico so spring gera respostas de requisiçoes web
        List<Category> list = categoryService.findAll(); // e este e para mostrar para o utlizador

        return ResponseEntity.ok().body(list);
    } // isto é um endpoint para buscar todas as categorias no postman ou broweser
    @GetMapping(value = "/{id}") // este Id se refere ao URL vai ser o argumento que vai ser passado como ID atravez da anotaçao PathVariable
    // la no Postman ou browser e so fazer o http://localhost:8080/users para os usuarios e http://localhost:8080/users/1 para
    // apahar o user com ID 1
    public ResponseEntity<Category> findById(@PathVariable Long id){
       Category obj = categoryService.findById(id);
       return ResponseEntity.ok().body(obj);
    }


}
