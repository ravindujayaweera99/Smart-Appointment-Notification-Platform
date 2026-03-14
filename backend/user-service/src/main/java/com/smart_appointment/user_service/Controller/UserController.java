package com.smart_appointment.user_service.Controller;

import com.smart_appointment.user_service.Entity.User;
import com.smart_appointment.user_service.Service.Implementation.UserServiceImplementation;
import com.smart_appointment.user_service.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User Created Successfully! " + user.getUserName();
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "User Updated Successfully! " + user.getUserName();
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "User Deleted Successfully! " + userId;
    }
}
