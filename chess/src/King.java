import javax.swing.*;
import java.util.ArrayList;

public class King extends Piece{
    public King(boolean white,int code,int[][] position){
        super(white,code,position);
        if(white)
            this.setIcon(new ImageIcon("w_king.png"));
        else
            this.setIcon(new ImageIcon("b_king.png"));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
    @Override
    public ArrayList<int[][]> getNextPossibleMove() {
        ArrayList<int[][]> np = new ArrayList<int[][]>();
        if (isLegalPosition(new int[][]{{x,y+1}}) && HumanPlayer.tiles[x][y+1].isEmpty()){
            np.add(new int[][]{{x, y+1}});
        }else{
            if (isLegalPosition(new int[][]{{x,y+1}}) && HumanPlayer.tiles[x][y+1].piece.white != this.white){
                np.add(new int[][]{{x, y+1}});
            }
        }
        if (isLegalPosition(new int[][]{{x+1,y+1}}) && HumanPlayer.tiles[x+1][y+1].isEmpty()){
            np.add(new int[][]{{x+1, y+1}});
        }else{
            if (isLegalPosition(new int[][]{{x+1,y+1}}) && HumanPlayer.tiles[x+1][y+1].piece.white != this.white){
                np.add(new int[][]{{x+1, y+1}});
            }
        }
        if (isLegalPosition(new int[][]{{x-1,y+1}}) && HumanPlayer.tiles[x-1][y+1].isEmpty()){
            np.add(new int[][]{{x-1, y+1}});
        }else{
            if (isLegalPosition(new int[][]{{x-1,y+1}}) && HumanPlayer.tiles[x-1][y+1].piece.white != this.white){
                np.add(new int[][]{{x-1, y+1}});
            }
        }
        if (isLegalPosition(new int[][]{{x-1,y}}) && HumanPlayer.tiles[x-1][y].isEmpty()){
            np.add(new int[][]{{x-1, y}});
        }else{
            if (isLegalPosition(new int[][]{{x-1,y}}) && HumanPlayer.tiles[x-1][y].piece.white != this.white){
                np.add(new int[][]{{x-1, y}});
            }
        }
        if (isLegalPosition(new int[][]{{x-1,y-1}}) && HumanPlayer.tiles[x-1][y-1].isEmpty()){
            np.add(new int[][]{{x-1, y-1}});
        }else{
            if (isLegalPosition(new int[][]{{x-1,y-1}}) && HumanPlayer.tiles[x-1][y-1].piece.white != this.white){
                np.add(new int[][]{{x-1, y-1}});
            }
        }
        if (isLegalPosition(new int[][]{{x,y-1}}) && HumanPlayer.tiles[x][y-1].isEmpty()){
            np.add(new int[][]{{x, y-1}});
        }else{
            if (isLegalPosition(new int[][]{{x,y-1}}) && HumanPlayer.tiles[x][y-1].piece.white != this.white){
                np.add(new int[][]{{x, y-1}});
            }
        }
        if (isLegalPosition(new int[][]{{x+1,y-1}}) && HumanPlayer.tiles[x+1][y-1].isEmpty()){
            np.add(new int[][]{{x+1, y-1}});
        }else{
            if (isLegalPosition(new int[][]{{x+1,y-1}}) && HumanPlayer.tiles[x+1][y-1].piece.white != this.white){
                np.add(new int[][]{{x+1, y-1}});
            }
        }
        if (isLegalPosition(new int[][]{{x+1,y}}) && HumanPlayer.tiles[x+1][y].isEmpty()){
            np.add(new int[][]{{x+1, y}});
        }else{
            if (isLegalPosition(new int[][]{{x+1,y}}) && HumanPlayer.tiles[x+1][y].piece.white != this.white){
                np.add(new int[][]{{x+1, y}});
            }
        }
        nextPossibleMove = np;
        return nextPossibleMove;
    }
}
