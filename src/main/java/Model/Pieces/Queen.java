package Model.Pieces;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Move;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queen extends Piece {
    public Queen(Color color, boolean isAlive) {
        super(color, isAlive);
    }

    @Override
    public boolean canKill(Board board, Cell cell, Piece piece) {
        if(this.color!=piece.color){
            if(this.cell.x==cell.x || this.cell.y==cell.y){
                return true;
            }
            else if(Math.abs(this.cell.x-cell.x)==Math.abs(this.cell.y-cell.y)){
                return true;
            }
        }
        return false;
    }

    @Override
    public HashSet<Move> possibleMoves(Board board) {
        HashSet<Move> possibleMoves = new HashSet<>();
        //x is current position and - is our moves
//       -
//       -
//       -
//       x
        for(int x=this.cell.x+1,y=this.cell.y; x<board.cells.length;x++){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//        x
//        -
//        -
//        -

        for(int x=this.cell.x-1,y=this.cell.y; x>=0;x--){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//               x  - - - -

        for(int x=this.cell.x,y=this.cell.y+1;  y<board.cells[0].length;y++){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//                       -  -  -  -  -   x


        for(int x=this.cell.x,y=this.cell.y-1; y>=0;y--){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }

        //x is current position and - is our moves
//        -
//                -
//                        -
//                                x
        for(int x=this.cell.x+1,y=this.cell.y-1; x<board.cells.length && y>=0;x++,y--){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//        x
//                -
//                        -
//                                -

        for(int x=this.cell.x-1,y=this.cell.y+1; x>=0 && y<board.cells[0].length;x--,y++){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//                                       -
//                                 -
//                            -
//                         x
        for(int x=this.cell.x+1,y=this.cell.y+1; x<board.cells.length && y<board.cells[0].length;x++,y++){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        //x is current position and - is our moves
//                                       x
//                                 -
//                            -
//                         -
//                   -

        for(int x=this.cell.x-1,y=this.cell.y-1; x>=0 && y>=0;x--,y--){
            if(board.cells[x][y].occuPipedBy!=null){
                if(board.cells[x][y].occuPipedBy.color!=this.color){
                    possibleMoves.add(new Move(this,x,y));
                }
                break;
            }
            else {
                possibleMoves.add(new Move(this,x,y));
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "♕";
    }

}
