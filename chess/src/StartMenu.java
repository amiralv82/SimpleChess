import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartMenu extends JFrame{
    JPanel mainPanel = new JPanel(new GridLayout(3, 2));
    JLabel background = new JLabel();
    JButton newGame = new JButton("New Game");
    JButton Continue = new JButton("continue");

    JButton human = new JButton("MULTI PLAYER");
    JButton ai = new JButton("SINGLE PLAYER");

    JButton whitebtn = new JButton("WHITE");
    JButton blackbtn = new JButton("BLACK");

    //this is Start menu
    public StartMenu(){
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setBackground(Color.white);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        background.setBounds(0, 0, 800, 550);
        background.setIcon(new ImageIcon("back.jpg"));
        background.setHorizontalAlignment(JLabel.CENTER);

        //New Game BUTTON
        newGame.setFont(new Font("Serif",Font.BOLD,20));
        newGame.setFocusPainted(false);
        newGame.setBackground(new Color(255,153,51));
        newGame.setBounds(300, 250, 200, 50);
        newGame.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Board.load = false;
                newGame.setVisible(false);
                Continue.setVisible(false);
                human.setVisible(true);
                ai.setVisible(true);
            }
        });
        //Continue BUTTON
        Continue.setFont(new Font("Serif",Font.BOLD,20));
        Continue.setFocusPainted(false);
        Continue.setBackground(new Color(255,153,51));
        Continue.setBounds(300, 350, 200, 50);
        Continue.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.load = true;
                try {
                    Main.start();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //MULTI PLAYER BUTTON
        human.setFont(new Font("Serif",Font.BOLD,20));
        human.setFocusPainted(false);
        human.setBackground(new Color(255,153,51));
        human.setBounds(300, 250, 200, 50);
        human.setVisible(false);
        human.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        human.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Board.ai=false;
                try {
                    Main.start();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //SINGLE PLAYER BUTTON
        ai.setFont(new Font("Serif",Font.BOLD,20));
        ai.setFocusPainted(false);
        ai.setBackground(new Color(255,153,51));
        ai.setBounds(300, 350, 200, 50);
        ai.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        ai.setVisible(false);
        ai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Board.ai = true;
                whitebtn.setVisible(true);
                blackbtn.setVisible(true);
            }
        });

        whitebtn.setFont(new Font("Serif",Font.BOLD,20));
        whitebtn.setFocusPainted(false);
        whitebtn.setBackground(new Color(255,153,51));
        whitebtn.setBounds(300, 250, 200, 50);
        whitebtn.setVisible(false);
        whitebtn.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        whitebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.ai = true;
                Board.aiWhite = false;
                try {
                    Main.start();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            }
        });

        blackbtn.setFont(new Font("Serif",Font.BOLD,20));
        blackbtn.setFocusPainted(false);
        blackbtn.setBackground(new Color(255,153,51));
        blackbtn.setBounds(300, 350, 200, 50);
        blackbtn.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(0x000000)));
        blackbtn.setVisible(false);
        blackbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.ai = true;
                Board.aiWhite = true;
                Board.white = !Board.white;
                try {
                    Main.start();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            }
        });


        this.add(blackbtn);
        this.add(whitebtn);
        this.add(human);
        this.add(ai);
        this.add(newGame);
        this.add(Continue);
        this.add(background);
        mainPanel.setBounds(200, 100, 400, 400);
        this.add(mainPanel);
        this.setVisible(true);
        this.pack();
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);

    }

}
