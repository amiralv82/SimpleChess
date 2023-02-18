import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Board extends JFrame implements Player{
    static boolean white = true;
    static int[][] p1;
    static int[][] p2;
    static Piece chosenPiece;
    static Tile[][] tiles = new Tile[8][8];
    static int[][] positions = {{-3,-5,-4,-2,-1,-4,-5,-3},{-6,-6,-6,-6,-6,-6,-6,-6},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{6,6,6,6,6,6,6,6},{3,5,4,2,1,4,5,3}};
    static JPanel boardPanel;
    static JPanel graveYard;
    static ArrayList<Piece> dead = new ArrayList<Piece>();
    JButton save;
    JButton newGame;
    public static boolean load;
    static JLabel theKingIsDead;
    AIPlayer aiPlayer = new AIPlayer();
    public static boolean ai;
    public static boolean aiWhite;
    Scanner reader = new Scanner(new File("save.txt"));
    static int flag;
    static int flag2;

    public Board() throws IOException {
        if (load){
            white = reader.nextInt() == 1;
            ai = reader.nextInt() == 1;
        }
        this.setTitle("Chess");
        boardPanel = new JPanel(new GridLayout(8,8));
        graveYard = new JPanel(new GridLayout(8, 4));
        save = new JButton("SAVE AND QUIT");
        save.setBounds(10,300,180,75);
        save.setBackground(Color.gray);
        save.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.black));
        save.setFont(new Font("MV BOLI",Font.BOLD,15));
        save.setFocusPainted(false);
        save.setBorderPainted(false);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    saveGame();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        newGame = new JButton("NEW GAME");
        newGame.setBounds(10,385,180,75);
        newGame.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.black));
        newGame.setBackground(Color.gray);
        newGame.setFont(new Font("MV BOLI",Font.BOLD,15));
        newGame.setFocusPainted(false);
        newGame.setBorderPainted(false);
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu startMenu = new StartMenu();
                white = true;
                positions = new int[][]{{-3, -5, -4, -1, -2, -4, -5, -3}, {-6, -6, -6, -6, -6, -6, -6, -6}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {6, 6, 6, 6, 6, 6, 6, 6}, {3, 5, 4, 2, 1, 4, 5, 3}};
                close();
            }
        });


        this.setLayout(null);
        this.setMinimumSize(new Dimension(1400, 900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        buildBoard(positions);
        this.pack();
        clickListener();

        if (aiWhite && ai){
            Board.positions = aiPlayer.nextMove(positions,aiWhite);
            buildBoard(Board.positions);
        }

    }


    public void clickListener(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Tile tile = tiles[i][j];
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if(!tile.isEmpty() && !tile.piece.white == white && p1 == null)
                            return;
                        //select icon
                        if(p1 == null && !tile.isEmpty()){
                            p1 = tile.position;
                            chosenPiece = tile.piece;
                            System.out.println("selected " + Arrays.deepToString(tile.position));
                            tile.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
                            for (int pos[][]:tiles[p1[0][0]][p1[0][1]].piece.nextPossibleMove){
                                Board.tiles[pos[0][0]][pos[0][1]].setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
                            }
                        }
                        //select position to go
                        else if(p1 != null && p2 == null && chosenPiece.canGoThere(tile.position)){
                            p2 = tile.position;
                            System.out.println("move to " + Arrays.deepToString(tile.position));
                            try {
                                nextMove(positions, white);
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (UnsupportedAudioFileException ex) {
                                ex.printStackTrace();
                            } catch (LineUnavailableException ex) {
                                ex.printStackTrace();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            p1 = null;
                            p2 = null;
                            chosenPiece = null;
                        }
                        else if(p1 != null && p2 == null && !chosenPiece.canGoThere(tile.position) && tile.piece != null && tile.piece.white == white){
                            //select another piece
                            tiles[p1[0][0]][p1[0][1]].setBorder(null);
                            for (int pos[][]:tiles[p1[0][0]][p1[0][1]].piece.nextPossibleMove){
                                Board.tiles[pos[0][0]][pos[0][1]].setBorder(null);
                            }
                            p1 = tile.position;
                            tile.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
                            for (int pos[][]:tiles[p1[0][0]][p1[0][1]].piece.nextPossibleMove){
                                Board.tiles[pos[0][0]][pos[0][1]].setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
                            }
                            System.out.println("selected " + Arrays.deepToString(tile.position));
                            chosenPiece = tile.piece;
                        }
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                });
            }
        }
    }

    //build the board with given map
    public void buildBoard(int[][] positions) throws FileNotFoundException {
        this.remove(boardPanel);
        boardPanel = new JPanel(new GridLayout(8,8));
        boardPanel.setBounds(200, 0, 800, 800);
        graveYard.setBounds(1000,0,400,800);
        this.setBackground(Color.darkGray);
        boardPanel.setBackground(Color.darkGray);

        //building tiles
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (load) {
                    Board.positions[i][j] = reader.nextInt();
                }
                tiles[i][j] = new Tile(new int[][]{{i , j}},Piece.createPiece(positions[i][j], new int[][]{{i , j}}));
                if(tiles[i][j].piece != null)
                    tiles[i][j].add(tiles[i][j].piece);

                if (i%2 == 0)
                    if (j%2 == 0)
                        tiles[i][j].setBackground(Color.white);
                    else
                        tiles[i][j].setBackground(Color.gray);
                else
                if (j%2 != 0)
                    tiles[i][j].setBackground(Color.white);
                else
                    tiles[i][j].setBackground(Color.gray);

                boardPanel.add(tiles[i][j]);
            }
        }

        //getting next possible moves for every piece
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (tiles[i][j].piece != null){
                    tiles[i][j].piece.getNextPossibleMove();
                }
            }
        }


        this.add(boardPanel);
        this.add(graveYard);
        this.add(save);
        this.add(newGame);
        this.pack();
        this.repaint();
        clickListener();
    }

    public void move(int[][] p1, int[][] p2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File mate = new File("checkmate.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(mate);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        if(!tiles[p2[0][0]][p2[0][1]].isEmpty()){
            tiles[p2[0][0]][p2[0][1]].setBorder(null);
            tiles[p2[0][0]][p2[0][1]].setBackground(new Color(240,240,240));
            if (tiles[p2[0][0]][p2[0][1]].piece.code == -1){
                tiles[p2[0][0]][p2[0][1]].setBorder(null);
                theKingIsDead = new JLabel();
                theKingIsDead.setBounds(500, 200 , 400, 400);
                theKingIsDead.setIcon(new ImageIcon("End.jpg"));
                theKingIsDead.setHorizontalTextPosition(JLabel.CENTER);
                theKingIsDead.setVerticalTextPosition(JLabel.CENTER);
                theKingIsDead.setForeground(Color.black);
                theKingIsDead.setFont(new Font("serif",Font.BOLD,25));
                theKingIsDead.setText("THE BLACK KING IS DEAD");
                theKingIsDead.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.black));
                theKingIsDead.setIconTextGap(-200);
                theKingIsDead.setOpaque(false);
                theKingIsDead.setVerticalAlignment(JLabel.CENTER);
                theKingIsDead.setHorizontalAlignment(JLabel.CENTER);
                clip.start();
                this.add(theKingIsDead);
            }else if (tiles[p2[0][0]][p2[0][1]].piece.code == 1){
                tiles[p2[0][0]][p2[0][1]].setBorder(null);
                theKingIsDead = new JLabel();
                theKingIsDead.setBounds(500, 200 , 400, 400);
                theKingIsDead.setIcon(new ImageIcon("End.jpg"));
                theKingIsDead.setHorizontalTextPosition(JLabel.CENTER);
                theKingIsDead.setVerticalTextPosition(JLabel.CENTER);
                theKingIsDead.setForeground(Color.WHITE);
                theKingIsDead.setFont(new Font("serif",Font.BOLD,25));
                theKingIsDead.setText("THE WHITE KING IS DEAD");
                theKingIsDead.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.white));
                theKingIsDead.setIconTextGap(-200);
                theKingIsDead.setOpaque(false);
                theKingIsDead.setVerticalAlignment(JLabel.CENTER);
                theKingIsDead.setHorizontalAlignment(JLabel.CENTER);
                clip.start();
                this.add(theKingIsDead);
            }else{
                tiles[p2[0][0]][p2[0][1]].setBorder(null);
                graveYard.add(tiles[p2[0][0]][p2[0][1]]);
                dead.add(tiles[p2[0][0]][p2[0][1]].piece);
            }
        }
        positions[p2[0][0]][p2[0][1]] = tiles[p1[0][0]][p1[0][1]].piece.code;

        positions[p1[0][0]][p1[0][1]] = 0;

        load = false;
    }

    @Override
    public int[][] nextMove(int[][] positions, boolean white) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (ai){
            move(p1, p2);
            if (flag2 == 0 && !aiWhite && !white)
                Board.positions = aiPlayer.nextMove(Board.positions, !aiWhite);
            else
                Board.positions = aiPlayer.nextMove(Board.positions, aiWhite);
            buildBoard(Board.positions);
            return Board.positions;
        }else{
            move(p1, p2);
            buildBoard(Board.positions);
            this.white = !this.white;
            return Board.positions;
        }

    }

    public static void saveGame() throws FileNotFoundException{
        PrintStream writer = new PrintStream(new File("save.txt"));
        if (ai)
            flag = 1;
        else
            flag = 0;
        if (white)
            flag2 = 1;
        else
            flag2 = 0;
        writer.print( flag2+ " "+flag);
        writer.println();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                writer.print(Board.positions[j][i] + " ");
            }
            writer.println();
        }
        if (dead.size() > 0){
            for (Piece p : dead) {
                writer.print(p.code + " ");
            }
        }
        System.exit(0);
    }

    public void close(){
        this.setVisible(false);
    }
}
