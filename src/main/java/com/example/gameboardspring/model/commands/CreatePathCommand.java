package com.example.gameboardspring.model.commands;


import com.example.gameboardspring.model.GameBoard;
import com.example.gameboardspring.validations.CheckPathArguments;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.gameboardspring.model.Node;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@ToString
public class CreatePathCommand{
    private GameBoard gameBoard;
    @CheckPathArguments
    private Node startNode;
    @CheckPathArguments
    private Node endNode;

}
