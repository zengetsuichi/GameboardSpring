package com.example.gameboardspring.controller;

import com.example.gameboardspring.model.commands.CreatePathCommand;
import com.example.gameboardspring.service.GameBoardProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class GameBoardControllerTest {

    @Autowired
    private MockMvc postman;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GameBoardProvider gameBoardProvider;


    @Test
    void shouldCreatePath() throws Exception {
        //given:

        CreatePathCommand createPathCommand = new CreatePathCommand();
        createPathCommand.setGameBoard(gameBoardProvider.getGameBoard());
        createPathCommand.setStartNode(0,0);
        createPathCommand.setEndNode(0,1);

        //when

        //then
    }
}