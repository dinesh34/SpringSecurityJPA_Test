package com.example.springsecutirty.jpaexample;

import java.util.Optional;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //We can return UserDetails instance here which accepts the username and get authentication
        //related values through a hardcoded UserDetails implemented class, or we can use JPA or H2 
        //to get the data

        //A harcorded class ; password and other stuff is harcoded-- not for production or development just test
        //return new MyUserDetails(username);

        //JPA way - get the data from reporsitory
        Optional<User> user  = userRepository.findByUsername(username);

        //if no value for username in found,
        if(user == null){
            throw new UsernameNotFoundException("Not found: "+ username);
        }

        //user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ username));
        //now we use those values to be mapped through our MyUserDetails
        return user.map(MyUserDetails::new).get();//map the user to new MyUserDetails constructor and get the output and return it
         
       
    }
    
    
}