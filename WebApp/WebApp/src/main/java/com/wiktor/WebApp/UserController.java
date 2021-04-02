package com.wiktor.WebApp;

import com.wiktor.WebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    MyUserDetailsService myUserDetailsService = new MyUserDetailsService();
    @Autowired
    private UserRepository userRepository;
    //Login
    @RequestMapping(path="/Checkuser")
    public String checkClient(String userName,String userPassword, Model model) {
        if (userName != null) {


            String pass = myUserDetailsService.loadUserByUsername(userName).getPassword();
            if(pass != userPassword){
                System.out.println("Blad");
            }

            System.out.println("zalogowano");
            model.addAttribute("message", "Zalogowano " + userName);
        }
        return "mainpage";
    }
    //Registration
    @RequestMapping(path="/Createuser", method = RequestMethod.POST)
    public String createClient(@ModelAttribute("registerform") RegisterForm registerForm, Model model) {
        if (registerForm.getUserName() != null) {
            User user = new User();

            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            user.setUserName(registerForm.getUserName());
            user.setUserPassword(passwordEncoder.encode(registerForm.getUserPassword()));
            user.setUserMail(registerForm.getUserMail());
            userRepository.save(user);
            System.out.println("Dziala");
            model.addAttribute("message", "User Created " + registerForm.getUserName());
        }
        return "registerpage";
    }

    @RequestMapping(path="/RegisterForm")
    public String register(@ModelAttribute("registerform") RegisterForm registerForm) {
        return "registerpage";
    }
}
