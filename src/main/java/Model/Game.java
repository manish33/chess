package Model;

import Model.Pieces.King;
import Model.Pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game{
    Player player1;
    Player player2;

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoves(HashMap<Player, HashSet<Move>> moves) {
        this.moves = moves;
    }

    public void setDeadPieces(HashMap<Player, HashSet<Piece>> deadPieces) {
        this.deadPieces = deadPieces;
    }

    GameStatus gameStatus;

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    Player currentPlayer;
    Board board;

    HashMap<Player,HashSet<Move>> moves;
    HashMap<Player, HashSet<Piece>> deadPieces;
    public HashMap<Player, HashSet<Piece>> getDeadPieces() {
        return deadPieces;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public HashMap<Player, HashSet<Move>> getMoves() {
        return moves;
    }

    public Game() {
        initializeGame();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Board getBoard() {
        return board;
    }

    public boolean initializeGame(){
          player1 = new Player("manish",Color.WHITE);
          player2 = new Player("Rohit",Color.BLACK);
          board = new Board();
          gameStatus= GameStatus.ACTIVE;
          currentPlayer = player1;
          moves = new HashMap<>();
          deadPieces = new HashMap<>();
          deadPieces.put(player1,new HashSet<Piece>());
          deadPieces.put(player2,new HashSet<Piece>());
          return true;
    }

    public boolean validPieceChoosen(Piece piece){
        if(piece==null){
            System.out.println("No piece at choosen Position");
            return false;
        }
        if(piece.color!=this.getCurrentPlayer().getColor()){
            System.out.println("Kindely choose Your Piece Only");
            return false;
        }
        return true;
    }

    public boolean executeMoveAndKillStatus(Move move){
        Cell currentCell = move.piece.cell;
        Cell destiNationCell = board.cells[move.end_x][move.end_y];
        Piece pieceToMove = move.piece;
        Piece destinationPiece = destiNationCell.occuPipedBy;
        currentCell.occuPipedBy=null;

        destiNationCell.occuPipedBy = pieceToMove;
        pieceToMove.cell = destiNationCell;
        boolean killedSomething= false;
        if(destinationPiece!=null){
            killedSomething = true;
            if(this.currentPlayer==player1){
                 deadPieces.get(player2).add(destinationPiece);
                 board.blackAlivePieces.remove(destinationPiece);
            }else {
                deadPieces.get(player1).add(destinationPiece);
                board.whiteAlivePieces.remove(destinationPiece);
            }
        }
        return killedSomething;
    }

    public boolean isKingUnderCheck(){
         if(currentPlayer==player1){
             Cell whiteKingPosition = board.whiteKing.cell;
             for(Piece blackAlive: board.blackAlivePieces){
                 for(Move move: blackAlive.possibleMoves(board)){
                     if(whiteKingPosition.x==move.end_x && whiteKingPosition.y==move.end_y){
                         return true;
                     }
                 }
             }
         }
         else {
             Cell blackKingPosition = board.blackKing.cell;
             for(Piece blackAlive: board.blackAlivePieces){
                 for(Move move: blackAlive.possibleMoves(board)){
                     if(blackKingPosition.x==move.end_x && blackKingPosition.y==move.end_y){
                         return true;
                     }
                 }
             }
         }

         return false;
    }

    public boolean isCheckMate(){
        if(currentPlayer==player1){
            HashSet<Move> blackAliveMoves= new HashSet<>();
            for(Piece blackAlive: board.blackAlivePieces){
                 blackAliveMoves.addAll(blackAlive.possibleMoves(board));
                }

            blackAliveMoves.containsAll(board.whiteKing.possibleMoves(board));
        }
        else {
            HashSet<Move> whiteAllmoves= new HashSet<>();
            for(Piece blackAlive: board.blackAlivePieces){
                whiteAllmoves.addAll(blackAlive.possibleMoves(board));
            }

            whiteAllmoves.containsAll(board.blackKing.possibleMoves(board));
        }

        return false;
    }
}
