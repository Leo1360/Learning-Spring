package com.example.mysql_access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysql_access.model.User;
import com.example.mysql_access.repos.UserRepo;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepo repo;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String nome, @RequestParam String email){
        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        repo.save(user);
        return "saved";
    }
    
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll(){
        return repo.findAll();
    }

}
