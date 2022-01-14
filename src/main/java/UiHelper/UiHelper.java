package UiHelper;

import Model.Board;
import Model.Cell;
import Model.Color;
import Model.Game;
import Model.Move;
import Model.Pieces.Piece;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UiHelper {

     Game game;
     Board board;
     Scanner scanner = new Scanner(System.in);
    public UiHelper(Game game) {

        this.game = game ;
        board= game.getBoard();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printBoard() {
        for (int i = 0; i < board.cells.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < board.cells[0].length; j++) {
                printPiece(board.cells[i][j].occuPipedBy, false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(Piece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.color == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    public int[] readPieceTomove(Game game) {
        Piece piece=null;
        int[] position=null;
        try {
            String s = scanner.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            if(!Character.isLetter(column) ||
                    Character.toLowerCase(column)<'a' ||
                    Character.toLowerCase(column)>'z' || row<=0 || row>8){
                System.out.println("Invalid Position choosen");
               return   readPieceTomove(game);
            }
            System.out.println("fine till here!");
            piece = board.cells[row-1][Character.toLowerCase(column)-'a'].occuPipedBy;
            System.out.println(row-1+":"+(Character.toLowerCase(column)-'a')+":"+piece);
           position = new int[]{row-1,Character.toLowerCase(column)-'a'};

        } catch (RuntimeException e) {
           return readPieceTomove(game);
        }
        finally {
            System.out.println(position+"sssc");
        }
        return position;
    }

    public void printCapturedPieces(Set<Piece> white,Set<Piece>  black) {
        System.out.println("Captured Pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.deepToString(white.toArray()));
        System.out.print(ANSI_RESET);

        System.out.print("Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.deepToString(black.toArray()));
        System.out.print(ANSI_RESET);

    }

    public void printBoardWithPossibleMoves(Set<Move> moves, Piece piece) {
        for (int i = 0; i < board.cells.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < board.cells[0].length; j++) {
                printPiece(board.cells[i][j].occuPipedBy, moves.contains(new Move(piece,i,j)));
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
        }

}
