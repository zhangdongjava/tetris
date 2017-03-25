package com.zzz.game.handler;

import com.zzz.game.dto.Constants;
import com.zzz.game.pojo.Scope;
import com.zzz.game.ui.GamePanel;

/**
 * Created by zd on 2017/3/25.
 */
public class GameMapHandler {

    /**
     * 当前地图二位数组 1 表示障碍物
     */
    private int[][] map;

    private GamePanel gamePanel;

    public GameMapHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        map = new int[Constants.GAME_HEIGHT][Constants.GAME_WIDTH];
    }

    public void autoDown() {
        scopeRun();
        gamePanel.setMap(map);
        gamePanel.repaint();
    }

    public void scopeRun() {
        Scope scope = gamePanel.getCurrScope();
        if (nextToObstacle(scope)) {
            gamePanel.setCurrScope(null);
            scopeToObstacle(scope);
            removeFill();
            printMap(map);
        } else {
            gamePanel.autoDown();
        }
    }

    /**
     * 删除填满了的
     */
    private void removeFill() {
        for (int i = map.length - 1; i >= 0; i--) {
            int[] ints = map[i];
            boolean b = fill(ints);
            if (b) {
                removeLine(i);
                i++;
            }
        }
    }

    private void removeLine(int i) {
        for (; i > 0; i--) {
            map[i] = map[i - 1];
        }
        for (int j = 0; j < map[0].length; j++) {
            map[0][j] = 0;
        }
    }

    public boolean fill(int[] i) {
        for (int j = 0; j < i.length; j++) {
            if (i[j] == 0) return false;

        }
        return true;
    }

    /**
     * 判断是否到底和下一步图形格子回合障碍物重叠
     *
     * @param scope
     * @return
     */
    public boolean nextToObstacle(Scope scope) {
        /**
         * 到上边的距离等于总格子高度数- 1  即为到底
         */
        boolean lastDown = scope.getY() + scope.getHeight() == Constants.GAME_HEIGHT - 1;
        if (lastDown) {
            return true;
        }

        return nextToObstacle(scope, 0, 1);
    }

    /**
     * 判断图形下一步是否会和障碍物重叠
     *
     * @param scope 图形对象
     * @param addX  当前图形x改变量
     * @param addY  当前图形 y改变量
     * @return
     */
    public boolean nextToObstacle(Scope scope, int addX, int addY) {
        int[][] points = scope.getCurr();
        int x = scope.getX() + addX;
        int y = scope.getY() + addY;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = 0; j < point.length; j++) {
                if (points[i][j] == 1 && map[i + y][j + x] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断图形下一步是否会和障碍物重叠
     * @param points 点
     * @param x
     * @param y
     * @return
     */
    public boolean nextToObstacle(int[][] points, int x, int y) {
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = 0; j < point.length; j++) {
                if (points[i][j] == 1 && map[i + y][j + x] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 图形变障碍
     *
     * @param scope
     */
    private void scopeToObstacle(Scope scope) {
        int[][] points = scope.getCurr();
        int x = scope.getX();
        int y = scope.getY();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = 0; j < point.length; j++) {
                int i1 = point[j];
                if (i1 == 1) {
                    map[i + y][j + x] = 1;
                }
            }
        }
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            int[] point = map[i];
            for (int j = 0; j < point.length; j++) {
                int i1 = point[j];
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMap(new int[Constants.GAME_WIDTH][Constants.GAME_HEIGHT]);
    }

    public void right() {
        Scope scope = gamePanel.getCurrScope();
        int x = scope.getCurrRight() + scope.getX() + 1;
        if (x >= 0 && x < Constants.GAME_WIDTH && !nextToObstacle(scope, 1, 0)) {
            scope.right();
            gamePanel.repaint();
        }
    }

    public void left() {
        Scope scope = gamePanel.getCurrScope();
        int x = scope.getCurrLeft() + scope.getX() - 1;
        if (x >= 0 && x < Constants.GAME_WIDTH && !nextToObstacle(scope, -1, 0)) {
            scope.left();
            gamePanel.repaint();
        }
    }

    public void change() {
        Scope scope = gamePanel.getCurrScope();
        int left = scope.getNextLeft();
        int height = scope.getNextHeight();
        int right = scope.getNextRight();
        /**
         * 到上边的距离等于总格子高度数- 1  即为到底
         */
        boolean lastDown = !(scope.getY() + height >= Constants.GAME_HEIGHT - 1);
        boolean isLeft = left >= 0 && left < Constants.GAME_WIDTH;
        boolean isRight = right >= 0 && right < Constants.GAME_WIDTH;
        if(lastDown&& isLeft && isRight && !nextToObstacle(scope.getNext(),scope.getX(),scope.getY())){
            scope.change();
            gamePanel.repaint();
        }
    }

    public void down() {
        Scope scope = gamePanel.getCurrScope();
        /**
         * 到上边的距离等于总格子高度数- 1  即为到底
         */
        boolean lastDown = scope.getY() + scope.getHeight() >= Constants.GAME_HEIGHT - 1;
        /**
         * 先判断到底 在判断时候和障碍物重叠 不然判断障碍物重叠要 异常
         */
        if (!lastDown && !nextToObstacle(scope, 0, 1)) {
            scope.down();
            gamePanel.repaint();
        }
    }
}
