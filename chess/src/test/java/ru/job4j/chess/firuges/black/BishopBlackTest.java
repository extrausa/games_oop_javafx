package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {
    @Test
    public void testPosition() {
        Figure black = new BishopBlack(Cell.C2);
        black.position();
        Cell a = black.position();
        assertThat(a, is(Cell.C2));


    }

    @Test
    public void testCopy() {
        Figure black = new BishopBlack(Cell.C1);
        Figure black1 = black.copy(Cell.C2);
        Cell b = black1.position();
        assertThat(b, is(Cell.C2));
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        Figure black = new BishopBlack(Cell.C1);
        //black.way(Cell.G5);
        Cell[] arrayResult = black.way(Cell.G5);
        Cell[] array = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        //Cell[] array = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(arrayResult, is(array));
    }
}