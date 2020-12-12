package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ServiceUser;
import java.security.Principal;


@Controller
public class UserController {

    private final ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/user")
    public String getUser(Model model, Principal principal){
        User user = serviceUser.getUserByName(principal.getName());
        model.addAttribute("user",user);
        return "userForm";
    }
}
