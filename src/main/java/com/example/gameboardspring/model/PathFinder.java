package com.example.gameboardspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PathFinder {

    private int[] row = {-1, 0, 0, 1};
    private int[] col = {0, -1, 1, 0};
    private Node startNode;
    private Node endNode;
    private GameBoard gameBoard;

    public PathFinder(GameBoard gameBoard, Node startNode, Node endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.gameBoard = gameBoard;
    }

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < gameBoard.getMatrix().length && y >= 0 && y < gameBoard.getMatrix()[0].length && gameBoard.getMatrix()[x][y] == 1);
    }


    private void findPath(Node node, List<String> path)
    {
        if (node != null) {
            findPath(node.getParent(), path);
            path.add(node.toString());
        }
    }

    public List<String> findPath(Node startNode, Node endNode) {

        Node currentNode = startNode;
        List<String> path = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(currentNode);

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            visited.add(currentNode.toString());

            int i = currentNode.getX();
            int j = currentNode.getY();

            if(i == endNode.getX() && j == endNode.getY()){
                findPath(currentNode, path);
                return path;
            }

            for (int k = 0; k < row.length; k++) {
                if (isValid(i + row[k], j + col[k]) && !visited.contains((i + row[k]) + " " + (j + col[k]))) {
                    queue.add(new Node(i + row[k], j + col[k], currentNode));
                }
            }

        }

        return path;

    }

}