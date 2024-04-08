package ru.proskuryakof.SpringBoot.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.proskuryakof.SpringBoot.model.User;
import ru.proskuryakof.SpringBoot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getList();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id")long id){
        return userService.getUserById(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        userService.create(user);
        return user;
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        userService.create(user);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id")long id){
        userService.delete(id);

    }


}
