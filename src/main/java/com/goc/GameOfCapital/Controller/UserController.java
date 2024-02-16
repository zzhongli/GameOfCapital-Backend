package com.goc.GameOfCapital.Controller;


import com.goc.GameOfCapital.Dto.User;
import com.goc.GameOfCapital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/users/{username}/{password}")
    public ResponseEntity<Optional<User>> createUser(@PathVariable String username,@PathVariable String password){

        if(userService.searchByUserName(username).isEmpty()){
            //store data receive from user to the database
            return new ResponseEntity<Optional<User>>(userService.createNewUser(username,password), HttpStatus.OK);
        }
        else{
            //username already exist
            return new ResponseEntity<Optional<User>>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }


    /**
     * return user data if it in the databse
     * else return 422
     * @param username
     * @return
     */
    @PostMapping("/api/sessions/{username}/{password}")   //named formal???
    public ResponseEntity<Optional<User>> userLogin(@PathVariable String username, @PathVariable String password){
//and password is correct

        if(userService.findPasswordByName(username).equals(password)){
            return new ResponseEntity<Optional<User>>(userService.searchByUserName(username), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Optional<User>>(HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }




}
