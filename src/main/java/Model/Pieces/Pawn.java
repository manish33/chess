package Model.Pieces;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Move;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    boolean firstMove = true;

    public Pawn(Color color, boolean isAlive) {
        super(color, isAlive);
    }

//    public boolean validMove(Board board, Move move) {
//        int xDiff = this.cell.x - move.end_x;
//        int yDiff = this.cell.y - move.end_y;
//        Piece piece = board.cells[move.end_x][move.end_y].occuPipedBy;
//        if (this.color == Color.WHITE) {
//            if (firstMove == true) {
//                if ((xDiff == 1 || xDiff == 2) && yDiff == 0) {
//                    return true;
//                } else return xDiff == 1 && Math.abs(yDiff) == 1 && piece.color != this.color;
//            } else {
//                if (xDiff == 1 && yDiff == 0) {
//                    return true;
//                } else return xDiff == 1 && Math.abs(yDiff) == 1 && piece.color != this.color;
//            }
//        } else {
//            if (firstMove == true) {
//                if ((xDiff == -1 || xDiff == -2) && yDiff == 0) {
//                    return true;
//                } else return xDiff == -1 && Math.abs(yDiff) == 1 && piece.color != this.color;
//            } else {
//                if (xDiff == -1 && yDiff == 0) {
//                    return true;
//                } else return xDiff == -1 && Math.abs(yDiff) == 1 && piece.color != this.color;
//            }
//        }
//    }

    public boolean canKill(Board board, Cell cell, Piece pieceToKill) {
        if (this.color == Color.WHITE && pieceToKill.color == Color.BLACK) {
            int xDiff = this.cell.x - cell.x;
            int yDiff = this.cell.y - cell.y;
            return xDiff == 1 && Math.abs(yDiff) == 1;
        } else if (this.color == Color.BLACK && pieceToKill.color == Color.WHITE) {
            int xDiff = this.cell.x - cell.x;
            int yDiff = this.cell.y - cell.y;
            return xDiff == -1 && Math.abs(yDiff) == 1;
        }
        return false;
    }

    @Override
    public HashSet<Move> possibleMoves(Board board) {
        HashSet<Move> possibleMoves = new HashSet<>();


        // logic => White can go x+1 or x+2 based on first move or not
        //       => Black can go x-1 or x-2 based on first move or not

        if (this.color == Color.WHITE) {
            if (firstMove) {
                if (this.cell.x + 1 < board.cells.length &&
                        board.cells[this.cell.x + 1][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y));
                }
                if (this.cell.x + 2 < board.cells.length &&
                        board.cells[this.cell.x + 2][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x + 2, this.cell.y));
                }
                if (this.cell.x + 1 < board.cells.length &&
                        this.cell.y - 1 >=0 &&
                        (board.cells[this.cell.x + 1][this.cell.y - 1].occuPipedBy != null && board.cells[this.cell.x + 1][this.cell.y - 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y - 1));
                }

                if (this.cell.x + 1 < board.cells.length &&
                        this.cell.y + 1 < board.cells.length &&
                        (board.cells[this.cell.x + 1][this.cell.y + 1].occuPipedBy != null && board.cells[this.cell.x + 1][this.cell.y + 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y + 1));
                }
            } else {
                if (this.cell.x + 1 < board.cells.length &&
                        board.cells[this.cell.x + 1][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y));
                }
                if (this.cell.x + 1 < board.cells.length &&
                        this.cell.y - 1 < board.cells.length &&
                        (board.cells[this.cell.x + 1][this.cell.y - 1].occuPipedBy != null && board.cells[this.cell.x + 1][this.cell.y - 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y - 1));
                }

                if (this.cell.x + 1 < board.cells.length &&
                        this.cell.y + 1 < board.cells.length &&
                        (board.cells[this.cell.x + 1][this.cell.y + 1].occuPipedBy != null && board.cells[this.cell.x + 1][this.cell.y + 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x + 1, this.cell.y + 1));
                }
            }
        } else {
            if (firstMove) {
                if (this.cell.x - 1 < board.cells.length &&
                        board.cells[this.cell.x - 1][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y));
                }
                if (this.cell.x - 2 < board.cells.length &&
                        board.cells[this.cell.x - 2][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x - 2, this.cell.y));
                }
                if (this.cell.x - 1 >=0 &&
                        this.cell.y - 1 >=0&&
                        (board.cells[this.cell.x - 1][this.cell.y - 1].occuPipedBy != null && board.cells[this.cell.x - 1][this.cell.y - 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y - 1));
                }

                if (this.cell.x-1>=0 &&
                        this.cell.y + 1 < board.cells.length &&
                        (board.cells[this.cell.x - 1][this.cell.y + 1].occuPipedBy != null && board.cells[this.cell.x - 1][this.cell.y + 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y + 1));
                }
            }
            else {
                if (this.cell.x - 1 >=0 &&
                        board.cells[this.cell.x - 1][this.cell.y].occuPipedBy == null) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y));
                }
                if (this.cell.x - 1 >=0 &&
                        this.cell.y - 1 >=0&&
                        (board.cells[this.cell.x - 1][this.cell.y - 1].occuPipedBy != null && board.cells[this.cell.x - 1][this.cell.y - 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y - 1));
                }

                if (this.cell.x - 1 >=0 &&
                        this.cell.y + 1 < board.cells.length &&
                        (board.cells[this.cell.x - 1][this.cell.y + 1].occuPipedBy != null && board.cells[this.cell.x - 1][this.cell.y + 1].occuPipedBy.color != this.color)) {
                    possibleMoves.add(new Move(this, this.cell.x - 1, this.cell.y + 1));
                }
            }

        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        return "♙";
    }

}
