package com.goc.GameOfCapital.Controller;

import com.goc.GameOfCapital.Dto.Game;
import com.goc.GameOfCapital.Dto.User;
import com.goc.GameOfCapital.Service.GameService;
import com.goc.GameOfCapital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/sessions/user?name={username}&password={password}/game")
    public ResponseEntity<List<Game>> getGame(@PathVariable String username, @PathVariable String password) {

        if (userService.userVerfied(username, password)) {
            return new ResponseEntity<List<Game>>(gameService.getGame(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Game>>(HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }}
