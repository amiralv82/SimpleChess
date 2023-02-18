import javax.swing.*;
import java.util.ArrayList;
import java.util.jar.JarEntry;

public abstract class Piece extends JLabel {
    boolean white;
    int code;
    int[][] position;
    int x;
    int y;
    ArrayList<int[][]> nextPossibleMove;

    public Piece(boolean white, int code, int[][] position){
        this.white = white;
        this.code = code;
        this.x = position[0][0];
        this.y = position[0][1];


    }
    public boolean isLegalPosition(int[][] position){
        return position[0][0] <= 7 && position[0][0] >= 0 && position[0][1] <= 7 && position[0][1] >= 0;
    }
    public static Piece createPiece(int code, int[][] position){
        switch (code) {
            case 3 -> {
                Piece Wrokh = new Rokh(true, code, position);
                return Wrokh;
            }
            case 5 -> {
                Piece Wnight = new Knight(true, code, position);
                return Wnight;
            }
            case 1 -> {
                Piece Wking = new King(true, code, position);
                return Wking;
            }
            case 2 -> {
                Piece Wqueen = new Queen(true, code, position);
                return Wqueen;
            }
            case 4 -> {
                Piece Wbishop = new Bishop(true, code, position);
                return Wbishop;
            }
            case 6 -> {
                Piece Wpawn = new Pawn(true, code, position);
                return Wpawn;
            }
            case -3 -> {
                Piece Brokh = new Rokh(false, code, position);
                return Brokh;
            }
            case -5 -> {
                Piece Bnight = new Knight(false, code, position);
                return Bnight;
            }
            case -1 -> {
                Piece Bking = new King(false, code, position);
                return Bking;
            }
            case -2 -> {
                Piece Bqueen = new Queen(false, code, position);
                return Bqueen;
            }
            case -4 -> {
                Piece Bbishop = new Bishop(false, code, position);
                return Bbishop;
            }
            case -6 -> {
                Piece Bpawn = new Pawn(false, code, position);
                return Bpawn;
            }
            default -> {
                return null;
            }
        }
    }

    public boolean canGoThere(int[][] p){
        for(int[][] position : this.nextPossibleMove){
            if(position[0][0] == p[0][0] && position[0][1] == p[0][1])
                return true;
        }
        return false;
    }


    public abstract ArrayList<int[][]> getNextPossibleMove();
}
