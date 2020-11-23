package ru.job4j.chess.firuges.black;

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
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX();
        int deltaY = position.getY();
        for (int index = 0; index < steps.length; index++) {
            if (position.getX() < dest.getX()) {
                steps[index] = Cell.findBy(deltaX + 1 + index,  deltaY - 1 - index);
            } else {
                steps[index] = Cell.findBy(deltaX - 1 - index, deltaY + 1 + index);
            }

        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            return true;
        }

        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
