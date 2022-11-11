package com.christian.onlineProject.controller;


import com.christian.onlineProject.models.User;
import com.christian.onlineProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineProjectController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepository.findAll();


    }

    @PostMapping(value = "/save")   //intotdeauna cand salvam un user facem un post
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepository.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        updateUser.setFacultate(user.getFacultate());
        userRepository.save(updateUser);
        return "Updated...";

    }

    @DeleteMapping(value = "/delete/{id}")
   public String deleteUser(@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser); // apelam metoda delete pe acel user repository si selectam useru pe care il stergem
        return "Delete user with the id:" +id;
   }


}
