package destinybutton;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class ButtonFrame extends JFrame implements ActionListener {
     
     private JLabel mainLabel;
     private JLabel copyrightLabel;
     private JButton goodButton;
     private JButton badButton; 
     private JButton restartButton; 
     private JButton songButton; 
     private Clip clip;

     public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
          new ButtonFrame();
     }

     public ButtonFrame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
          File song = new File("song/songDark.wav");
          AudioInputStream darkSong = AudioSystem.getAudioInputStream(song);

          this.clip = AudioSystem.getClip();
          this.clip.open(darkSong);
          this.clip.start(); 

          this.getContentPane().setBackground(Color.BLACK);
          this.setIconImage(new ImageIcon("img/iconButton.png").getImage());
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(300, 520);
          this.setResizable(false);
          this.setLayout(null);
          this.setTitle("Botão do Destino");

          this.mainLabel = new JLabel();
          this.mainLabel.setBounds(45, 25, 256, 170);
          this.mainLabel.setText("Escolha seu destino!");
          this.mainLabel.setIcon(new ImageIcon("img/iconPointing.png"));
          this.mainLabel.setHorizontalTextPosition(JLabel.CENTER);
          this.mainLabel.setVerticalTextPosition(JLabel.BOTTOM);
          this.mainLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
          this.mainLabel.setForeground(Color.WHITE);

          this.copyrightLabel = new JLabel();
          this.copyrightLabel.setBounds(10, 460, 200, 20);
          this.copyrightLabel.setText("Pedro Botelho - 2021");
          this.copyrightLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
          this.copyrightLabel.setForeground(Color.WHITE);

          this.goodButton = new JButton();
          this.goodButton.setBounds(70, 200, 160, 60);
          this.goodButton.setText("Botão do Bem!");
          this.goodButton.setFocusable(false);
          this.goodButton.addActionListener(this);
          this.goodButton.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
          this.goodButton.setBorder(BorderFactory.createEtchedBorder());
          this.goodButton.setBackground(Color.WHITE);

          this.badButton = new JButton();
          this.badButton.setBounds(70, 280, 160, 60);
          this.badButton.setText("Botão do Mau!");
          this.badButton.setFocusable(false);
          this.badButton.addActionListener(this);
          this.badButton.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
          this.badButton.setBorder(BorderFactory.createEtchedBorder());
          this.badButton.setBackground(Color.WHITE);

          this.songButton = new JButton();
          this.songButton.setBounds(70, 360, 70, 60);
          this.songButton.setIcon(new ImageIcon("img/iconPause.png"));
          this.songButton.setFocusable(false);
          this.songButton.addActionListener(this);
          this.songButton.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
          this.songButton.setBorder(BorderFactory.createEtchedBorder());
          this.songButton.setBackground(Color.WHITE);

          this.restartButton = new JButton();
          this.restartButton.setBounds(160, 360, 70, 60);
          this.restartButton.setIcon(new ImageIcon("img/iconRestart.png"));
          this.restartButton.setFocusable(false);
          this.restartButton.addActionListener(this);
          this.restartButton.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
          this.restartButton.setBorder(BorderFactory.createEtchedBorder());
          this.restartButton.setBackground(Color.WHITE);
          this.restartButton.setEnabled(false);

          this.add(goodButton);
          this.add(badButton);
          this.add(mainLabel);
          this.add(restartButton);
          this.add(songButton);
          this.add(copyrightLabel);
          
          this.setLocationRelativeTo(null);
          this.setVisible(true);
     }

     @Override
     public void actionPerformed(ActionEvent e){
          if(e.getSource() == this.goodButton){
               this.goodButton.setEnabled(false);
               this.badButton.setEnabled(true);
               this.goodButton.setBackground(Color.GREEN);
               this.badButton.setBackground(Color.WHITE);
               this.mainLabel.setIcon(new ImageIcon("img/iconAngel.png"));
               this.mainLabel.setText("Você escolheu o bem!");
               this.mainLabel.setForeground(Color.GREEN);
               this.mainLabel.setVisible(true);
               if(!this.restartButton.isEnabled()){
                    this.restartButton.setEnabled(true);
               }
          }
          else if(e.getSource() == this.badButton){
               this.goodButton.setEnabled(true);
               this.badButton.setEnabled(false);
               this.goodButton.setBackground(Color.WHITE);
               this.badButton.setBackground(Color.RED);
               this.mainLabel.setIcon(new ImageIcon("img/iconDevil.png"));
               this.mainLabel.setText("Você escolheu o mau!");
               this.mainLabel.setForeground(Color.RED);
               this.mainLabel.setVisible(true);
               if(!this.restartButton.isEnabled()){
                    this.restartButton.setEnabled(true);
               }
          }
          else if(e.getSource() == this.restartButton){
               this.mainLabel.setIcon(null);
               this.mainLabel.setIcon(new ImageIcon("img/iconPointing.png"));
               this.mainLabel.setText("Escolha seu destino!");
               this.mainLabel.setForeground(Color.WHITE);
               this.goodButton.setEnabled(true);
               this.goodButton.setBackground(Color.WHITE);
               this.badButton.setEnabled(true);
               this.badButton.setBackground(Color.WHITE);
               this.restartButton.setEnabled(false);
          }
          else if(e.getSource() == this.songButton){
               if(this.clip.isRunning()){
                    this.clip.stop();
                    this.songButton.setIcon(new ImageIcon("img/iconPlay.png"));
               }
               else{
                    this.clip.start();
                    this.songButton.setIcon(new ImageIcon("img/iconPause.png")); 
               }
          }
     }
}
