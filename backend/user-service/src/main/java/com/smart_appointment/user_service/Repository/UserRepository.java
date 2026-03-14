package com.smart_appointment.user_service.Repository;

import com.smart_appointment.user_service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
