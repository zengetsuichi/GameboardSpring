package com.example.gameboardspring.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class Bitmap {
    Node startNode;
    Node endNode;
    PathFinder pathFinder = new PathFinder();
    GameBoard gameBoard = new GameBoard();

    List<String> path = pathFinder.findPath(startNode, endNode);

    int matrix[][] = gameBoard.getMatrix();

    BufferedImage img = new BufferedImage(matrix.length, matrix[0].length, BufferedImage.TYPE_INT_RGB);

    public void createBitmap() throws Exception {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    img.setRGB(i, j, Color.WHITE.getRGB());
                } else {
                    img.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }


        for (String node : path) {
            String[] coordinates = node.split(",");

            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = coordinates[i].replace("{", "");
                coordinates[i] = coordinates[i].replace("}", "");
            }

            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            img.setRGB(x, y, Color.RED.getRGB());
        }


        File file = new File("C:\\Users\\Peter\\Desktop\\Kurs Java\\Rozszezenie\\GameboardSpring\\img.png");
        ImageIO.write(img, "png", file);
    }
}
