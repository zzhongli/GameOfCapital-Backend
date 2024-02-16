package com.goc.GameOfCapital.Reporistory;

import com.goc.GameOfCapital.Dto.Game;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameReporistory extends MongoRepository<Game, ObjectId> {

}
