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

    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    //Login
    @RequestMapping(path="/Checkuser")
    public String checkClient(@ModelAttribute("loginform") LoginForm loginForm, Model model) {
        if (loginForm.getUserName() != null) {


            String pass = myUserDetailsService.loadUserByUsername(loginForm.getUserName()).getPassword();
            if(pass != loginForm.getUserPassword()){
                System.out.println("Blad");
                return "mainpage";
            }

            System.out.println("zalogowano");
            model.addAttribute("message", "Zalogowano " + loginForm.getUserName());
        }
        return "homepage";
    }

    @RequestMapping(path="/LoginForm")
    public String login(LoginForm loginForm) {
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
