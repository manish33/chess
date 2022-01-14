package Helper;

import Model.Board;
import Model.Cell;
import Model.Move;
import Model.Pieces.Piece;

public class BasicValidation {


    public static boolean isValidMove(Board board, Move move, Piece piece) {

        // cordinates of the move is outside the boundary
        if (piece.cell.x < 0 ||
                piece.cell.y < 0 ||
                move.end_x < 0 ||
                move.end_y < 0 ||
                piece.cell.x >= board.cells.length ||
                piece.cell.y >= board.cells[0].length ||
                move.end_x >= board.cells.length ||
                move.end_y >= board.cells[0].length) {
            return false;
        }

        Cell end = board.cells[move.end_x][move.end_y];

        // piece at which we want to move is of same color. white can not kill white
        if(piece.isSameColor(end.occuPipedBy)){
            return  false;
        }

        return false;
    }
}
