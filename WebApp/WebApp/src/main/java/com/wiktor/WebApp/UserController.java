package com.wiktor.WebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    //Login
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(path="/Checkeuser")
    public String createClient(@RequestParam(required = false) String UserPassword, String UserName, String UserMail, Model model) {
        if (UserName != null) {


            userRepository.;


        }
        return "mainpage";
    }
    //Registration
    @RequestMapping(path="/Createuser")
    public String createClient(String UserPassword, String UserName, String UserMail, Model model) {
        if (UserName != null) {
            UserModel user = new UserModel();
            user.setUserName(UserName);

            userRepository.save(user);

           // model.addAttribute("message", "User Created " + UserName);
        }
        return "registerpage";
    }
}
