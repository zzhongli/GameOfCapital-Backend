package com.goc.GameOfCapital.Service;

import com.goc.GameOfCapital.Dto.Game;
import com.goc.GameOfCapital.Reporistory.GameReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameReporistory gameReporistory;


    public List<Game> getGame(){
        return gameReporistory.findAll();

    }


    /**
     * in the user repository
     * @return
     */
//    public int getScore(){
//        return
//    }

}
