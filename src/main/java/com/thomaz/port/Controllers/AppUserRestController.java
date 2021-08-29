package com.thomaz.port.Controllers;

import java.util.Map;
import java.util.Optional;

import com.thomaz.port.Models.AppUser;
import com.thomaz.port.Models.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appUser")
public class AppUserRestController {
    
    @Autowired
    private AppUserRepository appUserRepository;
    
    @GetMapping("/all")
    public Iterable<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    @PostMapping("/new")
    public String create(@RequestBody AppUser appUser){
        appUserRepository.save(appUser);
        return "appUser " + appUser.getName() + " was created successfully.";
    }

    @PutMapping("/update")
    public String update(@RequestBody AppUser appUser){
        Optional<AppUser> existingAppUser = appUserRepository.findById(appUser.getId());
        if(existingAppUser.isPresent()){
            appUserRepository.save(appUser);
            return "appUser " + appUser.getName() + " was updated successfully.";
        }
        else {
            return "appUser does not exist";
        }
        
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Map<String, Integer> json){
        Integer id = json.get("id");
        appUserRepository.deleteById(id);
        return "appUser was deleted.";
    }
}
