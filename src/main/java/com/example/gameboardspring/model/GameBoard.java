package com.example.gameboardspring.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameBoard {

    private final int[][] matrix = {
            {1, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
    };
}
