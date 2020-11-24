package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Ignore
    @Test(expected = OccupiedCellException.class)
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);

        assertThat(logic, is (new OccupiedCellException()));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveC1doD3()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.D3);

        assertThat(logic, is (new ImpossibleMoveException()));
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveNulldoD3()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C3, Cell.C3);

        assertThat(logic, is (new FigureNotFoundException()));
    }


}