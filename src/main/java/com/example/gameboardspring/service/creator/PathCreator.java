package com.example.gameboardspring.service.creator;

import com.example.gameboardspring.exceptions.IllegalMoveException;
import com.example.gameboardspring.model.GameBoard;
import com.example.gameboardspring.model.Node;
import com.example.gameboardspring.model.PathFinder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PathCreator {

    //Podwójna walidacja?

        public PathFinder create(GameBoard gameBoard, Node startNode, Node endNode) {

            return new PathFinder(gameBoard, startNode, endNode);
        }
}
