package ru.proskuryakof.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.proskuryakof.SpringBoot.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName (String name);
}
