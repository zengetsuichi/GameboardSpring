package com.example.gameboardspring.service;

import com.example.gameboardspring.model.GameBoard;
import org.springframework.stereotype.Service;

@Service
public class GameBoardProvider {

    private GameBoard gameBoard = new GameBoard();

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
