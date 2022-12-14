package com.github.hanyaeger;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import javax.swing.Timer;

public class GameTimer extends EntitySpawner {
    private Timer timer;
    private int second;
    private boolean spawnBoss = false;
    private TextEntity timerText;
    private Main main;
    private int limit;

    protected GameTimer(TextEntity timerText, Main main, int limit) {
        super(0);
        this.limit = limit;
        this.timerText = timerText;
        this.main = main;
    }

    public void StartTimer(){
        second = limit;
        Timer();
        timer.start();
    }

    public void Timer(){
        timer = new Timer(1000, e -> {
            timerText.setText("Timer: " + second);
            second--;
            if(second == 0){
                spawnBoss = true;
                timer.stop();
            }
        });
    }

    @Override
    protected void spawnEntities() {
        if (spawnBoss){
            main.setActiveScene(2);
            spawnBoss = false;
        }
    }
}
