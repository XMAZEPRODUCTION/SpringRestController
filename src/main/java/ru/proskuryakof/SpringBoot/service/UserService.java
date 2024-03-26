package ru.proskuryakof.SpringBoot.service;
import ru.proskuryakof.SpringBoot.model.User;
import java.util.List;
public interface UserService {
    void create (User user);
    User getUserById (Long id);
    void delete (Long id);
    List<User> getList();
}