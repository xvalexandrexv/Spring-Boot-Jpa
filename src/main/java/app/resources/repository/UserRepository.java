package app.resources.repository;

import app.resources.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // isto e para registrar
public interface UserRepository extends JpaRepository <User, Long>{

    // serve para guardar os objetos na base de dados


    User findByName(String name); // rafa


}
