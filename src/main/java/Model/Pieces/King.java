package Model.Pieces;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Move;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class King extends Piece {

    public King(Color color, boolean isAlive) {
        super(color, isAlive);
    }

    @Override
    public boolean canKill(Board board, Cell cell, Piece piece) {

        if(this.color!=piece.color){
         int xDiff = Math.abs(this.cell.x-cell.x);
         int yDiff = Math.abs(this.cell.y-cell.y);
         if((xDiff==0 && yDiff==1) || (yDiff==0 && xDiff==1) || (xDiff==1 && yDiff==1)){
             return true;
         }
        }
        return false;
    }

    @Override
    public HashSet<Move> possibleMoves(Board board) {
        HashSet<Move> possibleMoves = new HashSet<>();

        if(this.cell.x+1<board.cells.length &&
                (board.cells[this.cell.x+1][this.cell.y].occuPipedBy==null ||  board.cells[this.cell.x+1][this.cell.y].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y));
        }
        if(this.cell.x-1>=0 &&
                (board.cells[this.cell.x-1][this.cell.y].occuPipedBy==null ||   board.cells[this.cell.x-1][this.cell.y].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x-1,this.cell.y));
        }
        if(this.cell.y+1<board.cells.length &&
                (board.cells[this.cell.x][this.cell.y+1].occuPipedBy==null ||  board.cells[this.cell.x][this.cell.y+1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.y+1,this.cell.y));
        }
        if(this.cell.y-1>=0 &&
                this.cell.x+1<board.cells.length &&
                (board.cells[this.cell.x+1][this.cell.y-1].occuPipedBy==null ||    board.cells[this.cell.x+1][this.cell.y-1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.y-1,this.cell.y));
        }
        if(this.cell.x+1<board.cells.length &&
                this.cell.y+1<board.cells[0].length &&
                (board.cells[this.cell.x+1][this.cell.y+1].occuPipedBy==null ||   board.cells[this.cell.x+1][this.cell.y+1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y+1));
        }
        if(this.cell.x+1<board.cells.length &&
                this.cell.y-1>=0 &&
                (board.cells[this.cell.x+1][this.cell.y-1].occuPipedBy==null ||     board.cells[this.cell.x+1][this.cell.y-1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x+1,this.cell.y-1));
        }
        if(this.cell.x-1>=0 &&
                this.cell.y+1<board.cells[0].length &&
                (board.cells[this.cell.x-1][this.cell.y+1].occuPipedBy==null ||    board.cells[this.cell.x-1][this.cell.y+1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x-1,this.cell.y+1));
        }
        if(this.cell.x-1>=0 &&
                this.cell.y-1>=0 &&
                (board.cells[this.cell.x-1][this.cell.y-1].occuPipedBy==null ||  board.cells[this.cell.x-1][this.cell.y-1].occuPipedBy.color!=this.color)){
            possibleMoves.add(new Move(this,this.cell.x-1,this.cell.y-1));
        }

        if(this.color == Color.WHITE){
            for(Piece piece: board.blackAlivePieces){
                for(Move move: piece.possibleMoves(board)){
                    possibleMoves.remove(move);
                }
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "♔";
    }
}
