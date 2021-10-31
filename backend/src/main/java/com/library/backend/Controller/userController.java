package com.library.backend.Controller;

import com.library.backend.Entity.userEntity;
import com.library.backend.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class userController {

    private final userService userService;
    @Autowired
    public userController(com.library.backend.Service.userService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerNewUser(@RequestBody userEntity user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/update/{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {

        userService.updateUser(userId, name, email);
    }
}
