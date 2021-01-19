package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Beatware extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private final JLabel menuBar= new JLabel(new ImageIcon(Main.class.getResource("../../images/menu.png")));
    private int mouseX, mouseY;
    //image icon 초기화
    private final ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/exitButtonBasic.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/startButtonBasic2.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/startButtonEntered2.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/quitButtonBasic2.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/quitButtonEntered2.png"));
    private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/leftButtonBasic2.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/leftButtonEntered2.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/rightButtonBasic2.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/rightButtonEntered2.png"));
    private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/easyButtonBasic2.png"));
    private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/easyButtonEntered2.png"));
    private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/hardButtonBasic2.png"));
    private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/hardButtonEntered2.png"));
    private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../../images/backButtonBasic2.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../../images/backButtonEntered2.png"));

    private Image background = new ImageIcon(Main.class.getResource("../../images/introBackground.jpg")).getImage();

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);
    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);
    private JButton backButton = new JButton(backButtonBasicImage);

    Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;
    private boolean isHard = false;

    public static ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    private Music introMusic = new Music("introMusic2.mp3", true);
    private int nowSelected = 0;
    public static Game game;

    public Beatware(){
        trackList.add(new Track("Ed Sheeran - Shape Of You title.png","Ed Sheeran - Shape Of You 600x450.jpg", "Ed Sheeran - Shape Of You 1280x720.jpg",
                "Ed Sheeran - Shape Of You sample.mp3", "Ed Sheeran - Shape Of You.mp3", "Ed Sheeran - Shape Of You"));
        trackList.add(new Track("Imagine Dragons - Believer title.png","Imagine Dragons - Believer 600x450.jpg", "Imagine Dragons - Believer 1280x720.jpg",
                "Imagine Dragons - Believer sample.mp3", "Imagine Dragons - Believer.mp3", "Imagine Dragons - Believer"));
        trackList.add(new Track("Imagine Dragons - Natural title.png","Imagine Dragons - Natural 600x450.jpg", "Imagine Dragons - Natural 1280x720.jpg",
                "Imagine Dragons - Natural sample.mp3", "Imagine Dragons - Natural.mp3", "Imagine Dragons - Natural"));

        setUndecorated(true);
        setTitle("Beatware");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);
        addKeyListener(new KeyListener());

        introMusic.start();

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
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
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
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                introMusic.close();
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
                enterMain();
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
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
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

        // left 버튼
        leftButton.setVisible(false);
        leftButton.setBounds(140,310,60,60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectLeft();
            }
        });
        add(leftButton);


        // right 버튼
        rightButton.setVisible(false);
        rightButton.setBounds(1080,310,60,60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectRight();
            }
        });
        add(rightButton);


        // easy 버튼
        easyButton.setVisible(false);
        easyButton.setBounds(375,580,250,67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                isHard = false;
                gameStart(nowSelected);

            }
        });
        add(easyButton);

        // hard 버튼
        hardButton.setVisible(false);
        hardButton.setBounds(655,580,250,67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                isHard = true;
                gameStart(nowSelected);

            }
        });
        add(hardButton);


        // back 버튼
        backButton.setVisible(false);
        backButton.setBounds(20,50,60,60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic2.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //to main
                backMain();

            }
        });
        add(backButton);



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
    }
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }
    public void screenDraw(Graphics2D g){
        g.drawImage(background, 0, 0, null);
        paintComponents(g);

        if(isMainScreen)
        {
            g.drawImage(selectedImage,340,100,null);
            g.drawImage(titleImage, 340, 70, null);
        }
        if(isGameScreen)
        {
            String gameName = trackList.get(nowSelected).getGameMusic();
            game.screenDraw(g,gameName,isHard);
        }
        paintComponents(g);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if(selectedMusic !=null)
            selectedMusic.close();
        titleImage = new ImageIcon(Main.class.getResource("../../images/"+trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../../images/"+trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft(){
        if(nowSelected ==0) {
            nowSelected = trackList.size() - 1;
        }
        else {
            nowSelected--;
        }

        selectTrack(nowSelected);
    }
    public void selectRight() {
        if (nowSelected == trackList.size() - 1)
            nowSelected = 0;
        else
            nowSelected++;

        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected)
    {
        if(selectedMusic!=null)
            selectedMusic.close();
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        backButton.setVisible(true);
        background = new ImageIcon(Main.class.getResource("../../images/"+trackList.get(nowSelected).getGameImage())).getImage();
        isGameScreen=true;
        game = new Game(trackList.get(nowSelected).getTitleName(),isHard, trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void backMain() {
        isMainScreen = true;
        isGameScreen = false;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        backButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../../images/mainBackground2.jpg")).getImage();
        selectTrack(nowSelected);
        game.close();
        setFocusable(true);
        requestFocus();
    }
    public void enterMain(){
        startButton.setVisible(false);
        quitButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../../images/mainBackground2.jpg")).getImage();
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        isMainScreen = true;
        introMusic.close();
        selectTrack(0);
        setFocusable(true);
        requestFocus();
    }
}
