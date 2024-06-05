package app.resources.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // anotaçao JAP - passo 1 - converte esta classe para objecto relacional, ou seja cria uma tabela com estes atributos na tabela de base de dados
@Table(name = "tb_user")
public class User implements Serializable {
    // passo 2 - atribuir uma chave primaria, é so escolher um dos atributos e colocar o @ID

    @Id // jpa
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "client") // para mapear do lado do usuario e tenho que dizer o nome do atributo que esta la do outro lado da associaçao
    // linha 20 do lado da classe Order
    private List<Order> orders = new ArrayList<>();

    public User() {

    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
