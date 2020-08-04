
package com.example.springsecutirty.jpaexample;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeResource{
    
    @GetMapping(value = "/")
    public String Hello(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping(value = "/user")
    public String HelloUser(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping(value = "/admin")
    public String HelloAdmin(){
        return ("<h1>Welcome Admin</h1>");
    }


}