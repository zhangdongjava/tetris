package com.zzz.game.pojo;

import com.zzz.game.dto.Constants;

import java.awt.*;

/**
 * Created by zd on 2017/3/25.
 */
public class Scope {

    private int index;

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void right() {
        ++x;
    }

    public void left() {
        --x;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int[][][] points;

    public Scope(int[][][] p, int x, int y) {
        index = 0;
        this.x = x;
        this.y = y;
        points = p;
    }

    public int[][] getCurr() {
        return this.points[index];
    }

    public int[][] getNext() {
        return this.points[(index + 1) % points.length];
    }



    public void change() {
        index = (++index) % points.length;
    }

    public void draw(Graphics graphics, int size) {
        graphics.setColor(Color.red);
        int[][] p = getCurr();
        for (int i = 0; i < p.length; i++) {
            int[] ints = p[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt != 0) {
                    graphics.fillRect(
                            (j + x) * Constants.GAME_SIZE + 1,
                            (i + y) * Constants.GAME_SIZE + 1,
                            size,
                            size);
                }
            }
        }
    }

    public void down() {
        ++y;
    }

    /**
     * y 到最底下一个方块的高度
     *
     * @return
     */
    public int getHeight() {
        int[][] p = getCurr();
        int height = p.length - 1;
        for (; height >= 0; height--) {
            int[] ints = p[height];
            for (int anInt : ints) {
                if (anInt == 1) {
                    return height;
                }
            }
        }
        return height;
    }

    /**
     * 获取变形后左边第一个方块到 x距离
     *
     * @return
     */
    public int getCurrLeft() {
        int[][] p = getCurr();
        int x = 0;
        for (; x < p[0].length; x++) {
            for (int y = 0; y < p.length; y++) {
                int v = p[y][x];
                if (v == 1) return x;
            }
        }
        return x;
    }

    /**
     * 获取变形后右边第一方块到 x的距离
     *
     * @return
     */
    public int getCurrRight() {
        int[][] p = getCurr();
        int x = p[0].length - 1;
        for (; x >= 0; x--) {
            for (int y = 0; y < p.length; y++) {
                int v = p[y][x];
                if (v == 1) {
                    return x;
                }
            }
        }
        return x;
    }

    /**
     * 获取变形后y 到最底下一个方块的高度
     *
     * @return
     */
    public int getNextHeight() {
        int[][] p = getNext();
        int height = p.length - 1;
        for (; height >= 0; height--) {
            int[] ints = p[height];
            for (int anInt : ints) {
                if (anInt == 1) {
                    return height;
                }
            }
        }
        return height;
    }

    /**
     * 获取变形后左边第一个方块到 x距离
     *
     * @return
     */
    public int getNextLeft() {
        int[][] p = getNext();
        int x = 0;

        for (; x < p[0].length; x++) {
            for (int y = 0; y < p.length; y++) {
                int v = p[y][x];
                if (v == 1) return x;
            }
        }
        return x;
    }

    /**
     * 获取变形后右边第一方块到 x距离
     *
     * @return
     */
    public int getNextRight() {
        int[][] p = getNext();
        int x = p[0].length - 1;
        for (; x >= 0; x--) {
            for (int y = 0; y < p.length; y++) {
                int v = p[y][x];
                if (v == 1) return x + 1;
            }
        }
        return x + 1;
    }
}
