package com.javaspring.springboot_api.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspring.springboot_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNome(String nome);
    List<User> findByNomeContaining(String parteDoNome);
}
