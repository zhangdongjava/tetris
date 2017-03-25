package com.zzz.game.ui;

import com.zzz.game.event.MyKeyEvent;
import com.zzz.game.handler.GameMapHandler;
import com.zzz.game.timer.AutoDownTimer;

import javax.swing.*;

/**
 * Created by zd on 2017/3/25.
 */
public class MainWindow extends JFrame {

    private GamePanel gamePanel;

    public MainWindow() {
        this.setSize(600, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        gamePanel = new GamePanel();
        GameMapHandler gameMapHandler = new GameMapHandler(gamePanel);
        new AutoDownTimer(gameMapHandler);
        this.addKeyListener(new MyKeyEvent(gameMapHandler));
        gamePanel.setLocation(20, 20);
        this.add(gamePanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
