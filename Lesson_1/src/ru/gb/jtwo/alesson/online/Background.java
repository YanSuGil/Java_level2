package ru.gb.jtwo.alesson.online;

import java.awt.*;

public class Background {

    private float timer;

    Background(MainCanvas canvas){
        Color color = new Color((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
        canvas.setBackground(color);
    }

    public void repaint(MainCanvas canvas, float deltaTime){
        timer += deltaTime;
        if ((int) timer == 2){
            Color color = new Color((int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255));
            canvas.setBackground(color);
            timer = 0;
        }
    }
}
