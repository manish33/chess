import Model.Game;
import Model.GameStatus;
import Model.Move;
import Model.Pieces.Piece;
import UiHelper.UiHelper;

import java.util.Set;

public class GameController extends Thread {
    Game game;
    UiHelper uiHelper;

    GameController() {
        game = new Game();
        System.out.println(game.getBoard().cells + "q");
        uiHelper = new UiHelper(game);
        uiHelper.printBoard();
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }

    @Override
    public void run() {

        while (game.getGameStatus() == GameStatus.ACTIVE) {
            int[] userSelectedPositionForMove;
            Piece pieceToMove;
            Move selectedMove = null;
            // check if King Under Check
            if (game.isKingUnderCheck()) {
                //if checkMate we finish
                if (game.isCheckMate()) {
                    if (game.getCurrentPlayer() == game.getPlayer1()) {
                        game.setGameStatus(GameStatus.BLACK_WIN);
                    } else {
                        game.setGameStatus(GameStatus.WHITE_WIN);
                    }
                    continue;
                }
                // else we force player to move king and not give option to move other piece
                else {
                    System.out.println("Your King Under Check! Save it");
                    if (game.getCurrentPlayer() == game.getPlayer1()) {
                        pieceToMove = game.getBoard().whiteKing;
                    } else {
                        pieceToMove = game.getBoard().blackKing;
                    }
                }

            }
            // not check then select piece to move
            else {
                userSelectedPositionForMove = uiHelper.readPieceTomove(game);
                pieceToMove = game.getBoard().cells[userSelectedPositionForMove[0]][userSelectedPositionForMove[1]].occuPipedBy;
                while (!game.validPieceChoosen(pieceToMove)) {
                    System.out.println("Choose Piece userSelectedPositionForMove from a1 to h8 from board");
                    uiHelper.clearScreen();
                    uiHelper.printBoard();
                    userSelectedPositionForMove = uiHelper.readPieceTomove(game);
                    pieceToMove = game.getBoard().cells[userSelectedPositionForMove[0]][userSelectedPositionForMove[1]].occuPipedBy;
                }
            }
            Set<Move> moves = pieceToMove.possibleMoves(game.getBoard());

            // If given player can not move just ask for another move
            while (moves.size() == 0) {
                System.out.println("No move for Piece, Choose other Piece");
                userSelectedPositionForMove = uiHelper.readPieceTomove(game);
                System.out.println(userSelectedPositionForMove[0] + ":x" + userSelectedPositionForMove[1]);
                pieceToMove = game.getBoard().cells[userSelectedPositionForMove[0]][userSelectedPositionForMove[1]].occuPipedBy;
                moves = pieceToMove.possibleMoves(game.getBoard());
                System.out.println(pieceToMove.color + " lll");
            }
            uiHelper.printBoardWithPossibleMoves(moves, pieceToMove);
            System.out.println("Chose Target from List of possible moves");
            int[] p2Mpve = uiHelper.readPieceTomove(game);
            selectedMove = new Move(pieceToMove, p2Mpve[0], p2Mpve[1]);
            while (!moves.contains(selectedMove)) {
                System.out.println("Chose Target from List of possible moves");
                p2Mpve = uiHelper.readPieceTomove(game);
                selectedMove = new Move(pieceToMove, p2Mpve[0], p2Mpve[1]);
            }

            boolean killedSomething = game.executeMoveAndKillStatus(selectedMove);
            if (killedSomething == true) {
                uiHelper.printCapturedPieces(game.getDeadPieces().get(game.getPlayer1()), game.getDeadPieces().get(game.getPlayer2()));
            }
            System.out.println("You want to move at" + p2Mpve[0] + ":" + p2Mpve[1]);
            uiHelper.printBoard();

            if (game.getCurrentPlayer() == game.getPlayer1()) {
                game.setCurrentPlayer(game.getPlayer2());
            } else {
                game.setCurrentPlayer(game.getPlayer1());
            }
        }
    }
}
