package ru.proskuryakof.SpringBoot.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.proskuryakof.SpringBoot.model.User;
import ru.proskuryakof.SpringBoot.service.UserService;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getList());
        return "userIndex";
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "new";
//    }

//    @PostMapping
//    public String create(@ModelAttribute("user") User user) {
//        userService.create(user);
//        return "redirect:/users";
//    }

//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "edit";
//    }

//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.create(user);
//        return "redirect:/users";
//    }


}
