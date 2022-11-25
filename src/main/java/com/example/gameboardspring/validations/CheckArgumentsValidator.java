package com.example.gameboardspring.validations;

import com.example.gameboardspring.model.GameBoard;
import com.example.gameboardspring.model.Node;
import com.example.gameboardspring.service.GameBoardProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

@RequiredArgsConstructor
public class CheckArgumentsValidator implements ConstraintValidator<CheckPathArguments, Node> {

    private final GameBoardProvider gameBoardProvider;

    @Override
    public boolean isValid(Node node, ConstraintValidatorContext constraintValidatorContext) {
        GameBoard gameBoard = gameBoardProvider.getGameBoard();
        int x = node.getX();
        int y = node.getY();
        return !(x < 0 || x >= gameBoard.getMatrix().length || y < 0 || y >= gameBoard.getMatrix()[0].length);

    }


}
