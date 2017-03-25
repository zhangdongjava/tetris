package com.zzz.game.ui;

import com.zzz.game.dto.Constants;
import com.zzz.game.factory.ScopeFactory;
import com.zzz.game.pojo.Scope;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zd on 2017/3/25.
 */
public class GamePanel extends JPanel {

    private Scope currScope;

    private int[][] map;

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Scope getCurrScope() {
        return currScope;
    }

    public void setCurrScope(Scope currScope) {
        this.currScope = currScope;
    }

    public GamePanel() {
        this.setSize(Constants.GAME_WIDTH * Constants.GAME_SIZE + 1,
                Constants.GAME_HEIGHT * Constants.GAME_SIZE + 1);
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currScope == null) {
            reCurrScope();
        }
        currScope.draw(g, Constants.GAME_SIZE - 2);
        obstacle(g);
        drawBgTable(g);
    }

    /**
     * 画背景表格
     * @param g
     */
    private void drawBgTable(Graphics g) {
        g.setColor(Color.gray);
        for (int w = 0; w < Constants.GAME_WIDTH; w++) {
            for (int h = 0; h < Constants.GAME_HEIGHT; h++) {
                g.drawRect(Constants.GAME_SIZE * w, Constants.GAME_SIZE * h,
                        Constants.GAME_SIZE, Constants.GAME_SIZE);
            }

        }
    }

    public void autoDown() {
        currScope.down();
    }

    public void reCurrScope() {
        System.out.println("生成一个图形...");
        currScope = ScopeFactory.getNextScope(5, 0);
    }

    public void obstacle(Graphics graphics) {
        if (map == null) return;
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < map.length; i++) {
            int[] ints = map[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt == 1) {
                    graphics.fillRect(
                            (j) * Constants.GAME_SIZE + 1,
                            (i) * Constants.GAME_SIZE + 1,
                            Constants.GAME_SIZE - 1,
                            Constants.GAME_SIZE - 1);
                }
            }
        }
    }
}
