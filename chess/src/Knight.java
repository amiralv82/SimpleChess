import javax.swing.*;
import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(boolean white,int code,int[][] position){
        super(white,code,position);
        if(white)
            this.setIcon(new ImageIcon("w_knight.png"));
        else
            this.setIcon(new ImageIcon("b_knight.png"));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public ArrayList<int[][]> getNextPossibleMove() {
        ArrayList<int[][]> np = new ArrayList<int[][]>();
        if (isLegalPosition(new int[][]{{x+2,y+1}}) && HumanPlayer.tiles[x+2][y+1].isEmpty()){
            np.add(new int[][]{{x+2, y+1}});
        }else{
            if (isLegalPosition(new int[][]{{x+2,y+1}}) && HumanPlayer.tiles[x+2][y+1].piece.white != this.white){
                np.add(new int[][]{{x+2, y+1}});
            }
        }
        if (isLegalPosition(new int[][]{{x+2,y-1}}) && HumanPlayer.tiles[x+2][y-1].isEmpty()){
            np.add(new int[][]{{x+2, y-1}});
        }else{
            if (isLegalPosition(new int[][]{{x+2,y-1}}) && HumanPlayer.tiles[x+2][y-1].piece.white != this.white){
                np.add(new int[][]{{x+2, y-1}});
            }
        }
        if (isLegalPosition(new int[][]{{x-2,y+1}}) && HumanPlayer.tiles[x-2][y+1].isEmpty()){
            np.add(new int[][]{{x-2, y+1}});
        }else{
            if (isLegalPosition(new int[][]{{x-2,y+1}}) && HumanPlayer.tiles[x-2][y+1].piece.white != this.white){
                np.add(new int[][]{{x-2, y+1}});
            }
        }
        if (isLegalPosition(new int[][]{{x-2,y-1}}) && HumanPlayer.tiles[x-2][y-1].isEmpty()){
            np.add(new int[][]{{x-2, y-1}});
        }else{
            if (isLegalPosition(new int[][]{{x-2,y-1}}) && HumanPlayer.tiles[x-2][y-1].piece.white != this.white){
                np.add(new int[][]{{x-2, y-1}});
            }
        }
        if (isLegalPosition(new int[][]{{x-1,y-2}}) && HumanPlayer.tiles[x-1][y-2].isEmpty()){
            np.add(new int[][]{{x-1, y-2}});
        }else{
            if (isLegalPosition(new int[][]{{x-1,y-2}}) && HumanPlayer.tiles[x-1][y-2].piece.white != this.white){
                np.add(new int[][]{{x-1, y-2}});
            }
        }
        if (isLegalPosition(new int[][]{{x+1,y-2}}) && HumanPlayer.tiles[x+1][y-2].isEmpty()){
            np.add(new int[][]{{x+1, y-2}});
        }else{
            if (isLegalPosition(new int[][]{{x+1,y-2}}) && HumanPlayer.tiles[x+1][y-2].piece.white != this.white){
                np.add(new int[][]{{x+1, y-2}});
            }
        }
        if (isLegalPosition(new int[][]{{x+1,y+2}}) && HumanPlayer.tiles[x+1][y+2].isEmpty()){
            np.add(new int[][]{{x+1, y+2}});
        }else{
            if (isLegalPosition(new int[][]{{x+1,y+2}}) && HumanPlayer.tiles[x+1][y+2].piece.white != this.white){
                np.add(new int[][]{{x+1, y+2}});
            }
        }
        if (isLegalPosition(new int[][]{{x-1,y+2}}) && HumanPlayer.tiles[x-1][y+2].isEmpty()){
            np.add(new int[][]{{x-1, y+2}});
        }else{
            if (isLegalPosition(new int[][]{{x-1,y+2}}) && HumanPlayer.tiles[x-1][y+2].piece.white != this.white){
                np.add(new int[][]{{x-1, y+2}});
            }
        }
        this.nextPossibleMove = np ;
        return np;
    }
}
