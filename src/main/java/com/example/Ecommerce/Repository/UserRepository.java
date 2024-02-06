package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //SELECT * FROM ecommerce_user
    //WHERE user_email= :userName;

    @Query(value = "SELECT u FROM User u WHERE u.email = :userName")
    User getUserByUsername(String userName);
}
