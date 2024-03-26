package ru.proskuryakof.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proskuryakof.SpringBoot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
