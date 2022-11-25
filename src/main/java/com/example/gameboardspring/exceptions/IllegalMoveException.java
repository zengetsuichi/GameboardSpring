package com.example.gameboardspring.exceptions;

import com.example.gameboardspring.model.Node;
import lombok.Value;

import java.util.Set;

@Value
public class IllegalMoveException extends RuntimeException {
    private final Set<Node> nodes;
}
