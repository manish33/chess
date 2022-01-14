package Helper;

import Model.Board;
import Model.Cell;
import Model.Move;
import Model.Pieces.Piece;

public class KingValidationHelper{

    public  static boolean isValidMove(Board board, Move move, Piece piece) {
        if(!BasicValidation.isValidMove(board,move,piece)){
            return false;
        }

        Cell currentPosition = board.cells[piece.cell.x][piece.cell.y];
        Cell endPosition = board.cells[move.end_x][move.end_y];

        if(isKingUnderCheck(board,move)){
            return false;
        }
        return false;
    }
    public static boolean isKingUnderCheck(Board board,Move move){
        Cell endCell = board.cells[move.end_x][move.end_y];

        return true;
    }
}
