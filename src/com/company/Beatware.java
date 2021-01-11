package com.company;

import javax.swing.*;
import java.awt.*;

public class Beatware extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon(Main.class.getResource("../../images/introBackground.jpg")).getImage();
    private JLabel menuBar= new JLabel(new ImageIcon(Main.class.getResource("../../images/menu.png")));
    private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../../images/exitButtonBasic.png")));
    private int mouseX, mouseY;

    public Beatware(){
        setUndecorated(true);
        setTitle("Beatware");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        menuBar.setBounds(0,0,1280,30);
        add(menuBar);

        exitButton.setBounds(50,50,30,30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        add(exitButton);

        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
    }
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }
    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);

        this.repaint();
    }

}
