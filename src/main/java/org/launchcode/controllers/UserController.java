package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {



    @GetMapping("")
    private String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    if (!verify.equals(user.getPassword())){
        model.addAttribute("Error", "Your passwords should match!");
        return "/user/add";
    }
    return "redirect:/user/index";
    }


}
