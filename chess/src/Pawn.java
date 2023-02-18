import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Pawn extends Piece{

    public Pawn(boolean white,int code,int[][] position){
        super(white,code,position);
        if(white)
            this.setIcon(new ImageIcon("w_pawn.png"));
        else
            this.setIcon(new ImageIcon("b_pawn.png"));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public ArrayList<int[][]> getNextPossibleMove() {
        ArrayList<int[][]> np = new ArrayList<int[][]>();
        if(!this.white){
            if (this.x == 1 && HumanPlayer.tiles[x + 1][y].isEmpty()){
                if (HumanPlayer.tiles[x + 2][y].isEmpty()){
                    np.add(new int[][]{{x + 2,y}});
                }
            }
            if (isLegalPosition(new int[][]{{x + 1,y}}) && HumanPlayer.tiles[x + 1][y].isEmpty()){
                np.add(new int[][]{{x+1,y}});
            }
            if (isLegalPosition(new int[][]{{x+1,y-1}}) && !HumanPlayer.tiles[x+1][y-1].isEmpty() &&  HumanPlayer.tiles[x+1][y-1].piece.white != this.white){
                np.add(new int[][]{{x+1,y-1}});
            }
            if (isLegalPosition(new int[][]{{x+1,y+1}}) && !HumanPlayer.tiles[x+1][y+1].isEmpty() && HumanPlayer.tiles[x+1][y+1].piece.white != this.white){
                np.add(new int[][]{{x+1,y+1}});
            }

        }
        else if(this.white){
            if (this.x == 6 && HumanPlayer.tiles[x - 1][y].isEmpty()){
                if (HumanPlayer.tiles[x -2][y].isEmpty()){
                    np.add(new int[][]{{x - 2,y}});
                }
            }
            if (isLegalPosition(new int[][]{{x - 1,y}}) && HumanPlayer.tiles[x - 1][y].isEmpty()){
                np.add(new int[][]{{x-1,y}});
            }
            if (isLegalPosition(new int[][]{{x-1,y-1}}) && !HumanPlayer.tiles[x-1][y-1].isEmpty() &&  HumanPlayer.tiles[x-1][y-1].piece.white != this.white){
                np.add(new int[][]{{x-1,y-1}});
            }
            if (isLegalPosition(new int[][]{{x-1,y+1}}) && !HumanPlayer.tiles[x-1][y+1].isEmpty() && HumanPlayer.tiles[x-1][y+1].piece.white != this.white){
                np.add(new int[][]{{x-1,y+1}});
            }
        }
        nextPossibleMove = np;
        return nextPossibleMove;
    }
}
