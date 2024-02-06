package com.example.Ecommerce.Services;

import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> saveAllUsers(List<User> allUsers){
        return userRepo.saveAll(allUsers);
    }

    public User findUserById(int id){
        Optional<User> findUserObj = userRepo.findById(id);
        return findUserObj.get();
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public boolean existUserById(int id){
        System.out.println(userRepo.existsById(id));
        return userRepo.existsById(id);
    }

    public void deleteUserById(int id){
        userRepo.deleteById(id);
    }

    public void deleteAllProducts(){
        userRepo.deleteAll();
    }

    public User updateUser(User user){
        User userObj = userRepo.saveAndFlush(user);
        return userObj;
    }

}
