package com.wiktor.WebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;
    //Login
    @RequestMapping(path="/Checkeuser")
    public String loginUser(@RequestParam(required = false) String UserPassword, String UserName, String UserMail, Model model) {
        if (UserName != null) {


        }
        return "mainpage";
    }
    //Registration
    @RequestMapping(path="/Createuser", method = RequestMethod.POST)
    public String createClient(String userPassword, String userName, String userMail, Model model) {
        if (userName != null) {
            User user = new User();

            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            user.setUserName(userName);
            user.setUserPassword(passwordEncoder.encode(userPassword));
            user.setUserMail(userMail);
            userRepository.save(user);
            System.out.println("jest");
            model.addAttribute("message", "User Created " + userName);
        }
        return "registerpage";
    }
}
