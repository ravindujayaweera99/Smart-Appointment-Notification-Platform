package com.smart_appointment.user_service.Service.Implementation;

import com.smart_appointment.user_service.Entity.User;
import com.smart_appointment.user_service.Repository.UserRepository;
import com.smart_appointment.user_service.Service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

   UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User Created Successfully!" + user.getUserName();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }


    //Update User
    @Override
    public String updateUser(User updatedUser) {

        Optional<User> existingUserCheck = userRepository.findById(updatedUser.getId());

        if(existingUserCheck.isPresent()){
            User existingUser = existingUserCheck.get();

            existingUser.setAge(updatedUser.getAge());
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setPassword(updatedUser.getPassword());
            userRepository.save(existingUser);
            return "User Updated Successfully!" + updatedUser.getUserName();
        } else {
            return "User Not Found" + updatedUser.getId();
        }
    }

    //Delete User
    @Override
    public String deleteUser(Long userId) {

        Optional<User> userCheck = userRepository.findById(userId);

        if(userCheck.isPresent()){
            User user = userCheck.get();
            user.setStatus(false);
            userRepository.save(user);
            return "User Deleted Successfully! " + userId;
        } else {
            return "User Not Found " + userId;
        }

    }
}
