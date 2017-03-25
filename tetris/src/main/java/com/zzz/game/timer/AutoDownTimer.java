package com.zzz.game.timer;

import com.zzz.game.handler.GameMapHandler;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zd on 2017/3/25.
 */
public class AutoDownTimer extends TimerTask {
    /**
     * 每次下落间隔时间
     */
    private static int time = 500;

    private GameMapHandler gameMapHandler;

    public AutoDownTimer(GameMapHandler gameMapHandler) {
        this.gameMapHandler = gameMapHandler;
        Executors.newScheduledThreadPool(10).scheduleAtFixedRate(this,time,time, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        gameMapHandler.autoDown();
    }
}
