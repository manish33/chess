package Model;

import Model.Pieces.Piece;

import java.util.Objects;

public class Move {
    public Piece piece;
    public int end_x;
    public int end_y;

    public Move(Piece piece,int end_x, int end_y) {
        this.piece = piece;
        this.end_x = end_x;
        this.end_y = end_y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return end_x == move.end_x &&
                end_y == move.end_y &&
                piece.equals(move.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piece, end_x, end_y);
    }
}
