package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import service.ServiceUser;

import java.util.List;

@Controller

public class UserController {

    private final ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", serviceUser.getAllUsers());
        return "table";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "userForm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        if (user.getId()==0){
            serviceUser.addUser(user);
        }else {
            serviceUser.updateUser(user);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model,@RequestParam Long id ){
        User user = serviceUser.getUserById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute("user")User user){
        serviceUser.removeUserById(user);
        return "redirect:/";
    }
}
