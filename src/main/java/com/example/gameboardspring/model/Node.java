package com.example.gameboardspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
public class Node {

    private int x;
    private int y;
    private Node parent;


    @Override
    public String toString() {
        return "{" + x +
                "," + y + '}';
    }
}
