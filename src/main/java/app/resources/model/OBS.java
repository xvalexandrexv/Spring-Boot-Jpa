package app.resources.model;

public class OBS {

    /*o projeto tem 3 camadas:
    -Controller - fazer pedidos, interçao entre o usuario e as regras do negocio
    -serviço- logica do negocio,
    -repository - guardar os obj na base de dados.


    1 - O nosso UserResource ou controller como podemos ver, chama o UserService
    ou seja o service.findAll();

    2 -  O nosso UserService por sua vez fala com o repositorio, repository.findAll();

    3 - E por ultimo o testConfig/UserRepository guarda os objetos na lista para guarda na base de dados.

    toda vez que fizermos uma dependencia temos que dizer ao spirng com o que

    @Autowired -- isto e para dizer que ele e dependente do registo ou da classe UserRepository.
    private UserRepository userRepository - depois vamos na classe e fazemos o registo do que ele é

    @Repository ----- isto é o registo.
    public interface UserRepository....


     */
}
