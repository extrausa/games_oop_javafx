package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX, deltaY;
        if (dest.getX() > position.getX()) {
            deltaX = 1;
        } else {
            deltaX = -1;
        }
        if (dest.getY() > position.getY()) {
            deltaY = 1;
        } else {
            deltaY = -1;
        }
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < steps.length; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x,y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
