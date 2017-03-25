package com.zzz.game.event;

import com.zzz.game.handler.GameMapHandler;
import com.zzz.game.pojo.Scope;
import com.zzz.game.ui.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by zd on 2017/3/25.
 */
public class MyKeyEvent extends KeyAdapter {

    private GameMapHandler gamePanel;

    public MyKeyEvent(GameMapHandler gamePanel) {

        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.left();
                break;
            case KeyEvent.VK_UP:
                gamePanel.change();
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.right();
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.down();
                break;
        }
    }
}
