package app.resources.configs;

import app.resources.repository.UserRepository;
import app.resources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // para dizer que é uma classe de configuraçao
@Profile("test") // para dizer que é uma classe de configuraçao mas de teste, essa palavra test tem que
// ser igual ao (spring.profiles.active=test) do file na pasta resources -> application proprieties linha 4
public class TestConfig implements CommandLineRunner {

    @Autowired // cria uma dependecia automatica com o userRepository via spring para mostrar para o utlizador
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Bob", "alex@gmail.com", "977777777", "123456");

        // para guardar agora os dadpos na base de dados

        userRepository.saveAll(Arrays.asList(u1, u2, u3)); // save all serve para guarda uma lista de objeto

    }
}
