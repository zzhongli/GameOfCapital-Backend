package com.goc.GameOfCapital.Dto;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    private ObjectId id;

    private int questionNumber;

    private String question;

    private String correctAnswer;

    private String wrongAnswer1;

    private String wrongAnswer2;

    private String wrongAnswer3;




}
