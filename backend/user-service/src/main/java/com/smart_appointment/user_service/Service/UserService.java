package com.smart_appointment.user_service.Service;

import com.smart_appointment.user_service.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(Long userId);

    public String createUser(User user);

    public String updateUser(User user);

    public String deleteUser(Long userId);

}
