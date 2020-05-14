package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainWindow extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];
    Background background;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        background = new Background(canvas);
        initApplication(0);
        add(canvas);
        setTitle("Circles");
        setVisible(true);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    sprites = Arrays.copyOf(sprites, sprites.length + 1);
                    initApplication(sprites.length - 1);
                }else if(e.getButton() == MouseEvent.BUTTON3){
                    sprites[sprites.length - 1] = null;
                    sprites = Arrays.copyOf(sprites, sprites.length - 1);
                }
            }
        });
    }

    private void initApplication(int j) {
        for (int i = j; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        background.repaint(canvas,deltaTime);
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

}
