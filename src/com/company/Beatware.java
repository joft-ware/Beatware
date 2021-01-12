package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Beatware extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon(Main.class.getResource("../../images/introBackground.jpg")).getImage();
    private JLabel menuBar= new JLabel(new ImageIcon(Main.class.getResource("../../images/menu.png")));
    private int mouseX, mouseY;
    //image icon 초기화
    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/exitButtonBasic.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/startButtonBasic.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/startButtonBasic.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/startButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/startButtonBasic.png"));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);

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

        // exit 버튼
        exitButton.setBounds(1245,0,30,30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        // start 버튼
        startButton.setBounds(40,200,400,100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // 게임 시작 이벤트!
            }
        });
        add(startButton);

        // quit 버튼
        quitButton.setBounds(40,330,400,100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(quitButton);










        menuBar.setBounds(0,0,1280,30);
        // menu 드래그
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x-mouseX, y-mouseY);
            }
        });

        add(menuBar);

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
