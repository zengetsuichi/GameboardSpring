package com.example.gameboardspring.controller;

import com.example.gameboardspring.exceptions.IllegalMoveException;
import com.example.gameboardspring.model.PathFinder;
import com.example.gameboardspring.model.commands.CreatePathCommand;
import com.example.gameboardspring.service.GameBoardProvider;
import com.example.gameboardspring.service.creator.PathCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paths/")
@RequiredArgsConstructor
@Slf4j
public class GameBoardController {

    private final GameBoardProvider gameBoardProvider;
    private final PathCreator pathCreator;


    @PostMapping("/findPath")
    public ResponseEntity findPath(@RequestBody @Valid CreatePathCommand createPathCommand) throws IllegalMoveException {
        log.info("createPath({})", createPathCommand);
        PathFinder created = pathCreator.create(gameBoardProvider.getGameBoard(), createPathCommand.getStartNode(), createPathCommand.getEndNode());
        List<String> path = created.findPath(createPathCommand.getStartNode(), createPathCommand.getEndNode());
        return ResponseEntity.status(HttpStatus.OK).body(path);
    }
}
