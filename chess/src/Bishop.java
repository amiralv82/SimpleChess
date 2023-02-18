import javax.swing.*;
import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(boolean white,int code,int[][] position){
        super(white,code,position);
        if(white)
            this.setIcon(new ImageIcon("w_bishop.png"));
        else
            this.setIcon(new ImageIcon("b_bishop.png"));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public ArrayList<int[][]> getNextPossibleMove() {
        ArrayList<int[][]> np = new ArrayList<int[][]>();
        int i = 1;
        while (isLegalPosition(new int[][]{{x+i,y+i}}) && HumanPlayer.tiles[x+i][y+i].isEmpty()){
            np.add(new int[][]{{x+i,y+i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x+i,y+i}}) && !HumanPlayer.tiles[x+i][y+i].isEmpty() && HumanPlayer.tiles[x+i][y+i].piece.white != this.white){
            np.add(new int[][]{{x+i,y+i}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x-i,y-i}}) && HumanPlayer.tiles[x-i][y-i].isEmpty()){
            np.add(new int[][]{{x-i,y-i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x-i,y-i}}) && !HumanPlayer.tiles[x-i][y-i].isEmpty() && HumanPlayer.tiles[x-i][y-i].piece.white != this.white){
            np.add(new int[][]{{x-i,y-i}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x+i,y-i}}) && HumanPlayer.tiles[x+i][y-i].isEmpty()){
            np.add(new int[][]{{x+i,y-i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x+i,y-i}}) && !HumanPlayer.tiles[x+i][y-i].isEmpty() && HumanPlayer.tiles[x+i][y-i].piece.white != this.white){
            np.add(new int[][]{{x+i,y-i}});
        }
        i=1;
        while (isLegalPosition(new int[][]{{x-i,y+i}}) && HumanPlayer.tiles[x-i][y+i].isEmpty()){
            np.add(new int[][]{{x-i,y+i}});
            i++;
        }
        if (isLegalPosition(new int[][]{{x-i,y+i}}) && !HumanPlayer.tiles[x-i][y+i].isEmpty() && HumanPlayer.tiles[x-i][y+i].piece.white != this.white){
            np.add(new int[][]{{x-i,y+i}});
        }
        nextPossibleMove = np;
        return nextPossibleMove;

    }
}
