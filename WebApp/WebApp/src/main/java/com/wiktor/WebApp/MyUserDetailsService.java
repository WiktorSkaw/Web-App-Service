package com.wiktor.WebApp;

import com.wiktor.WebApp.models.MyUserDetails;
import com.wiktor.WebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        //user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return new MyUserDetails(user);//user.map(MyUserDetails::new).get();
    }
}
