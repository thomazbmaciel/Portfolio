package com.thomaz.port.Controllers;

import java.util.Map;
import java.util.Optional;

import com.thomaz.port.Models.User;
import com.thomaz.port.Models.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/all")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/new")
    public String create(@RequestBody User user){
        userRepository.save(user);
        return "User " + user.getName() + " was created successfully.";
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        Optional<User> existingUser = userRepository.findById(user.getId());
        if(existingUser.isPresent()){
            userRepository.save(user);
            return "User " + user.getName() + " was updated successfully.";
        }
        else {
            return "User does not exist";
        }
        
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Map<String, Integer> json){
        Integer id = json.get("id");
        userRepository.deleteById(id);
        return "User was deleted.";
    }
}
