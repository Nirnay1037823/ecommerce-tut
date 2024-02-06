package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userServ;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user){
        return userServ.saveUser(user);
    }

    @PostMapping("/signupall")
    public List<User> saveAll(@RequestBody List<User> allUsers){
        return userServ.saveAllUsers(allUsers);
    }

    @GetMapping("/findbyid")
    public void findById(@RequestParam(name = "id") int id){
        if(userServ.existUserById(id)){
            System.out.println(userServ.findUserById(id));
        }else{
            System.out.println("User is not present");
        }
    }
    @GetMapping("/getall")
    public List<User> findall(){
        return userServ.findAllUsers();
    }

    @PostMapping("/deletebyid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") int id){
        try {
            boolean userExists = userServ.existUserById(id);
            if (userExists){
                userServ.deleteUserById(id);
                System.out.println("User id "+id+" successfully deleted");
            }else{
                System.out.println("Id does not exist");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PostMapping("/deleteall")
    public void deleteAll(){
        try {
            userServ.deleteAllProducts();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PostMapping("/updateuser")
    public User update(@RequestBody User user){
        User newUser = user;
        System.out.println("Id of new user is " + newUser.getId());
        if(userServ.existUserById(newUser.getId())){
            User updatedUser = userServ.updateUser(user);
            return updatedUser;
        }
        System.out.println("User does not exists");
        return null;
    }
}
