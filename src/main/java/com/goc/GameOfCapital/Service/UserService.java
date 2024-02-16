package com.goc.GameOfCapital.Service;

import com.goc.GameOfCapital.Dto.User;
import com.goc.GameOfCapital.Reporistory.UserReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.time.Clock;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserReporistory userReporistory;

    public Optional<User> searchByUserName(String username){
        return userReporistory.findByUsername(username);
    }

    public Optional<User> createNewUser(String username, String password){
        User newuser = new User(username,password, java.time.LocalDate.now().toString(),0);
        userReporistory.save(newuser);
        return userReporistory.findByUsername(username);

    }


    public String findPasswordByName(String username) {
        List<User> userList = userReporistory.findAll();
        String password = new String();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                password = userList.get(i).getPassword();
            }
        }
        return password;

    }

    public boolean userVerfied(String username, String password){
        if(!findPasswordByName(username).equals(password)) return false;
        else return true;

    }


}
