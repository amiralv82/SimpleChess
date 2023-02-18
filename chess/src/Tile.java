import javax.swing.*;

public class Tile extends JPanel {
    final int[][] position;
    Piece piece;

    public Tile(int[][] position,Piece piece){
        this.position = position;
        this.piece = piece;
    }

    public boolean isEmpty(){
        if (piece == null)
            return true;
        else
            return false;
    }
}
