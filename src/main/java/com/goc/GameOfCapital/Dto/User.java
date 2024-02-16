package com.goc.GameOfCapital.Dto;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private ObjectId id;

    private String username;

    private String password;

    private String registerDate;

    private int score;

    public User(String username, String password, String registerDate, int score) {
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.score = score;
    }


    public User(String username) {
        this.username=username;
    }
}
