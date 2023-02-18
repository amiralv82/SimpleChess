import javax.swing.*;
import java.util.ArrayList;

public class Rokh extends Piece{

    public Rokh(boolean white,int code,int[][] position){
        super(white,code,position);
        if(white)
            this.setIcon(new ImageIcon("w_rook.png"));
        else
            this.setIcon(new ImageIcon("b_rook.png"));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public ArrayList<int[][]> getNextPossibleMove() {
        ArrayList<int[][]> np = new ArrayList<int[][]>();
        int i = 1;
        while (isLegalPosition(new int[][]{{x,y+i}}) && HumanPlayer.tiles[x][y+i].isEmpty()){
            np.add(new int[][]{{x,y+i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x,y+i}}) && !HumanPlayer.tiles[x][y+i].isEmpty() && HumanPlayer.tiles[x][y+i].piece.white != this.white){
            np.add(new int[][]{{x,y+i}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x,y-i}}) && HumanPlayer.tiles[x][y-i].isEmpty()){
            np.add(new int[][]{{x,y-i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x,y-i}}) && !HumanPlayer.tiles[x][y-i].isEmpty() && HumanPlayer.tiles[x][y-i].piece.white != this.white){
            np.add(new int[][]{{x,y-i}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x+i,y}}) && HumanPlayer.tiles[x+i][y].isEmpty()){
            np.add(new int[][]{{x+i,y}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x+i,y}}) && !HumanPlayer.tiles[x+i][y].isEmpty() && HumanPlayer.tiles[x+i][y].piece.white != this.white){
            np.add(new int[][]{{x+i,y}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x-i,y}}) && HumanPlayer.tiles[x-i][y].isEmpty()){
            np.add(new int[][]{{x-i,y}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x-i,y}}) && !HumanPlayer.tiles[x-i][y].isEmpty() && HumanPlayer.tiles[x-i][y].piece.white != this.white){
            np.add(new int[][]{{x-i,y}});
        }
        nextPossibleMove = np;
        return nextPossibleMove;

    }
}
