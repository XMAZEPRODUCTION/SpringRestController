package ru.proskuryakof.SpringBoot.service;

import ru.proskuryakof.SpringBoot.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Set<Role> getRoleByName(String[] roleName);
}
