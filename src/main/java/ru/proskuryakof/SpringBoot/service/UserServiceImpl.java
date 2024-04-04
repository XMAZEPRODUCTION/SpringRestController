package ru.proskuryakof.SpringBoot.service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import ru.proskuryakof.SpringBoot.model.Role;
import ru.proskuryakof.SpringBoot.model.User;
import ru.proskuryakof.SpringBoot.repository.RoleRepository;
import ru.proskuryakof.SpringBoot.repository.UserRepository;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    @Override
    @Transactional
    public void create(User user) {
        if (user.getUsername().equals("")|user.getPassword().equals("")){
            throw new UsernameNotFoundException("User не имеет пароля и логина!");
        }else{
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }


    @Override
    public Long getUsernameByName(String name) {
        User user = userRepository.findByUsername(name);
        return user.getId();
    }

    @Override
    public User getUserAndRoles(User user, String[] roles) {
        if(roles==null){
            user.setRoles(roleService.getRoleByName(new String[]{"ROLE_USER"}));
        }else{
            user.setRoles(roleService.getRoleByName(roles));
        }
        return user;
    }

    @Override
    public User getNotNullRole(User user) {
        if (user.getRoles()==null){
            user.setRoles(Collections.singleton(new Role(2L)));
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username);
        if (username == null){
            throw new UsernameNotFoundException("User с именем " + username+ " не был найден!");
        }
        return userDetails;
    }
}