package Model.Pieces;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Move;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class Piece {
    public Color color;
    public boolean isAlive;
    public Cell cell;

    public Piece(Color color, boolean isAlive) {
        this.color = color;
        this.isAlive = isAlive;
    }

    public Piece(Cell cell) {
        this.cell = cell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return isAlive == piece.isAlive &&
                color == piece.color &&
                cell.equals(piece.cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, isAlive, cell);
    }

    public boolean isSameColor(Piece piece){
        return this.color==piece.color;
    }

    public  boolean validMove(Board board, Move move){
       return possibleMoves(board).contains(move);
    }
    public abstract boolean canKill(Board board, Cell cell, Piece piece);
    public abstract HashSet<Move> possibleMoves(Board board);
}
