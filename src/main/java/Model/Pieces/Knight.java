package Model.Pieces;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Move;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Knight extends Piece {
    public Knight(Color color, boolean isAlive) {
        super(color, isAlive);
    }

    @Override
    public boolean canKill(Board board, Cell cell, Piece piece) {
        if (this.color != piece.color) {
            int xdiff = Math.abs(this.cell.x - cell.x);
            int ydiff = Math.abs(this.cell.y - cell.y);
            return xdiff * ydiff == 2;
        }
        return false;
    }

    @Override
    public HashSet<Move> possibleMoves(Board board) {
        HashSet<Move> possibleMoves = new HashSet<>();
        //(1,2) (1,-2) (-1,2) (-1,-2)  (2,1) (2,-1),(-2,1),(-2,-1)

        //(1,2)
        if (this.cell.x + 1 < board.cells.length
                && this.cell.y + 2 < board.cells.length &&
                (board.cells[this.cell.x + 1][this.cell.y+2].occuPipedBy == null ||
                        board.cells[this.cell.x + 1][this.cell.y+2].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y+2));
        }

       // (1,-2)
        if (this.cell.x + 1 < board.cells.length
                && this.cell.y - 2 >=0 &&
                (board.cells[this.cell.x + 1][this.cell.y-2].occuPipedBy == null ||
                        board.cells[this.cell.x + 1][this.cell.y-2].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y-2));
        }

        //(-1,2)
        if (this.cell.x - 1 >=0
                && this.cell.y + 2 < board.cells.length &&
                (board.cells[this.cell.x - 1][this.cell.y+2].occuPipedBy == null ||
                        board.cells[this.cell.x - 1][this.cell.y+2].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y+2));
        }

      //  (-1,-2)

        if (this.cell.x - 1 >=0
                && this.cell.y - 2 >=0 &&
                (board.cells[this.cell.x - 1][this.cell.y-2].occuPipedBy == null ||
                        board.cells[this.cell.x - 1][this.cell.y-2].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x-1,this.cell.y-2));
        }

        //(2,1)
        if (this.cell.x + 2 < board.cells.length
                && this.cell.y + 1 < board.cells.length &&
                (board.cells[this.cell.x + 2][this.cell.y+1].occuPipedBy == null ||
                        board.cells[this.cell.x + 2][this.cell.y+1].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x+2,this.cell.y+1));
        }

        //(2,-1)

        if (this.cell.x + 2 < board.cells.length
                && this.cell.y -1 >=0 &&
                (board.cells[this.cell.x + 2][this.cell.y-1].occuPipedBy == null ||
                        board.cells[this.cell.x + 2][this.cell.y-1].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x+2,this.cell.y-1));
        }

      //  (-2,1)

        if (this.cell.x -2 >=0
                && this.cell.y + 1 < board.cells.length &&
                (board.cells[this.cell.x - 2][this.cell.y+1].occuPipedBy == null ||
                        board.cells[this.cell.x - 2][this.cell.y+1].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x-2,this.cell.y+1));
        }


      //  (-2,-1)

        if (this.cell.x -2 >=0
                && this.cell.y -1 >=0&&
                (board.cells[this.cell.x -2][this.cell.y-1].occuPipedBy == null ||
                        board.cells[this.cell.x -2][this.cell.y-1].occuPipedBy.color != this.color)
        ){
            possibleMoves.add(new Move(this,this.cell.x-2,this.cell.y-1));
        }

            return possibleMoves;
    }

    @Override
    public String toString() {
        return "♘";
    }
}
