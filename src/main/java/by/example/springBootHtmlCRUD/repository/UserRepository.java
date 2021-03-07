package by.example.springBootHtmlCRUD.repository;

import by.example.springBootHtmlCRUD.madel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
