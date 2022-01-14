package Model;

import Model.Pieces.Bishop;
import Model.Pieces.King;
import Model.Pieces.Knight;
import Model.Pieces.Pawn;
import Model.Pieces.Piece;
import Model.Pieces.Queen;
import Model.Pieces.Rook;

import java.util.HashSet;

public class Board {

   public Cell[][] cells;
   public HashSet<Piece> blackAlivePieces;
   public HashSet<Piece> whiteAlivePieces;
   public Piece whiteKing;
   public Piece blackKing;

    public Board() {
      resetBoard();
    }

    private void resetBoard() {

        // check arrangement.png in this folder.
        cells = new Cell[8][8];
        blackAlivePieces=new HashSet<>();
        whiteAlivePieces=new HashSet<>();
        // initialize white pieces
        cells[0][0] = new Cell(new Rook(Color.WHITE,true), 0, 0);          //white Rock
        whiteAlivePieces.add(cells[0][0].occuPipedBy);
        cells[0][1] = new Cell(new Knight(Color.WHITE,true), 0, 1);        //white Knight
        whiteAlivePieces.add(cells[0][1].occuPipedBy);
        cells[0][2] = new Cell(new Bishop(Color.WHITE,true), 0, 2);        //white Bishop
        whiteAlivePieces.add(cells[0][2].occuPipedBy);
        cells[0][3] = new Cell(new Queen(Color.WHITE,true), 0, 3);        //white Queen
        whiteAlivePieces.add(cells[0][3].occuPipedBy);

        cells[0][4] = new Cell(new King(Color.WHITE,true), 0, 4);         //white King
        whiteAlivePieces.add(cells[0][4].occuPipedBy);
        whiteKing = cells[0][4].occuPipedBy;

        cells[0][5] = new Cell(new Bishop(Color.WHITE,true), 0, 5);       //white Bishop
        whiteAlivePieces.add(cells[0][5].occuPipedBy);
        cells[0][6] = new Cell(new Knight(Color.WHITE,true), 0, 6);       //white Knight
        whiteAlivePieces.add(cells[0][6].occuPipedBy);
        cells[0][7] = new Cell(new Rook(Color.WHITE,true), 0, 7);       //white Rock
        whiteAlivePieces.add(cells[0][7].occuPipedBy);
        //...


        // white pawns
        cells[1][0] = new Cell(new Pawn(Color.WHITE,true),1, 0);
        whiteAlivePieces.add(cells[1][0].occuPipedBy);
        cells[1][1] = new Cell(new Pawn(Color.WHITE,true),1, 1);
        whiteAlivePieces.add(cells[1][1].occuPipedBy);
        cells[1][2] = new Cell(new Pawn(Color.WHITE,true),1, 2);
        whiteAlivePieces.add(cells[1][2].occuPipedBy);
        cells[1][3] = new Cell(new Pawn(Color.WHITE,true),1, 3);
        whiteAlivePieces.add(cells[1][3].occuPipedBy);
        cells[1][4] = new Cell(new Pawn(Color.WHITE,true),1, 4);
        whiteAlivePieces.add(cells[1][4].occuPipedBy);
        cells[1][5] = new Cell(new Pawn(Color.WHITE,true),1, 5);
        whiteAlivePieces.add(cells[1][5].occuPipedBy);
        cells[1][6] = new Cell(new Pawn(Color.WHITE,true),1, 6);
        whiteAlivePieces.add(cells[1][6].occuPipedBy);
        cells[1][7] = new Cell(new Pawn(Color.WHITE,true),1, 7);
        whiteAlivePieces.add(cells[1][7].occuPipedBy);
        //...

        // initialize black pieces
        cells[7][0] = new Cell(new Rook(Color.BLACK,true), 7, 0);          //Black Rock
        blackAlivePieces.add(cells[7][0].occuPipedBy);
        cells[7][1] = new Cell(new Knight(Color.BLACK,true), 7, 1);        //Black Knight
        blackAlivePieces.add(cells[7][1].occuPipedBy);
        cells[7][2] = new Cell(new Bishop(Color.BLACK,true), 7,2);        //Black Bishop
        blackAlivePieces.add(cells[7][2].occuPipedBy);
        cells[7][3] = new Cell(new Queen(Color.BLACK,true), 7, 3);        //Black Queen
        blackAlivePieces.add(cells[7][3].occuPipedBy);

        cells[7][4] = new Cell(new King(Color.BLACK,true), 7, 4);         //Black King
        blackAlivePieces.add(cells[7][4].occuPipedBy);
        blackKing = cells[7][4].occuPipedBy;

        cells[7][5] = new Cell(new Bishop(Color.BLACK,true), 7, 5);       //Black Bishop
        blackAlivePieces.add(cells[7][5].occuPipedBy);
        cells[7][6] = new Cell(new Knight(Color.BLACK,true), 7, 6);       //Black Knight
        blackAlivePieces.add(cells[7][6].occuPipedBy);
        cells[7][7] = new Cell(new Rook(Color.BLACK,true), 7, 7);         //Black Rock
        blackAlivePieces.add(cells[7][7].occuPipedBy);
        //...

        // black pawns
        cells[6][0] = new Cell(new Pawn(Color.BLACK,true), 6, 0);
        blackAlivePieces.add(cells[6][0].occuPipedBy);
        cells[6][1] = new Cell(new Pawn(Color.BLACK,true),6, 1);
        blackAlivePieces.add(cells[6][1].occuPipedBy);
        cells[6][2] = new Cell(new Pawn(Color.BLACK,true),6, 2);
        blackAlivePieces.add(cells[6][2].occuPipedBy);
        cells[6][3] = new Cell(new Pawn(Color.BLACK,true),6, 3);
        blackAlivePieces.add(cells[6][3].occuPipedBy);
        cells[6][4] = new Cell(new Pawn(Color.BLACK,true),6, 4);
        blackAlivePieces.add(cells[6][4].occuPipedBy);
        cells[6][5] = new Cell(new Pawn(Color.BLACK,true),6, 5);
        blackAlivePieces.add(cells[6][5].occuPipedBy);
        cells[6][6] = new Cell(new Pawn(Color.BLACK,true),6, 6);
        blackAlivePieces.add(cells[6][6].occuPipedBy);
        cells[6][7] = new Cell(new Pawn(Color.BLACK,true),6, 7);
        blackAlivePieces.add(cells[6][7].occuPipedBy);

        // initialize remaining cells without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(null, i, j);
            }
        }
    }


}
