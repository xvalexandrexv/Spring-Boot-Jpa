package app.resources.configs;

import app.resources.model.Category;
import app.resources.model.Order;
import app.resources.model.OrderStatus;
import app.resources.repository.CategoryRepository;
import app.resources.repository.OrderRepository;
import app.resources.repository.UserRepository;
import app.resources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration // para dizer que é uma classe de configuraçao
@Profile("test") // para dizer que é uma classe de configuraçao mas de teste, essa palavra test tem que
// ser igual ao (spring.profiles.active=test) do file na pasta resources -> application proprieties linha 4
public class TestConfig implements CommandLineRunner {

    @Autowired // cria uma dependecia automatica com o userRepository via spring para mostrar para o utlizador
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Bob", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");



        // para guardar agora os dadpos na base de dados

        userRepository.saveAll(Arrays.asList(u1, u2, u3)); // save all serve para guarda uma lista de objeto
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

    }
}
