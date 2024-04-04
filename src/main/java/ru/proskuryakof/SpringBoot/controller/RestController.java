package ru.proskuryakof.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.proskuryakof.SpringBoot.model.User;
import ru.proskuryakof.SpringBoot.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RestController {
    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping
    public List<User> getUsers(){
        return userService.getList();
    }

}
