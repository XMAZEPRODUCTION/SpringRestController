package ru.proskuryakof.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.proskuryakof.SpringBoot.model.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String name);
}
