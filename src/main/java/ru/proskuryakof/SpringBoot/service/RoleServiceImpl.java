package ru.proskuryakof.SpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.proskuryakof.SpringBoot.model.Role;
import ru.proskuryakof.SpringBoot.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Set<Role> getRoleByName(String[] roleName) {
        Set<Role> set = new HashSet<>();
        for (String role: roleName){
            set.add(roleRepository.findRoleByName(role));
        }
        return set;
    }
}
