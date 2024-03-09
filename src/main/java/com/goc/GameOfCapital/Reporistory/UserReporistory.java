package com.goc.GameOfCapital.Reporistory;


import com.goc.GameOfCapital.Dto.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReporistory extends MongoRepository<User, ObjectId> {
    public Optional<User> findByUsername(String username);


}
