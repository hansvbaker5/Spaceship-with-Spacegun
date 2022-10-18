package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameTimer extends EntitySpawner {
    private Timer timer;
    private int second;
    private boolean spawnBoss = false;
    private TextEntity timerText;

    protected GameTimer(TextEntity timerText) {
        super(0);
        this.timerText = timerText;
    }

    public void StartTimer(){
        second = 0;
        Timer();
        timer.start();
    }

    public void Timer(){
        timer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                timerText.setText("Timer: " + second);
                second++;
                if(second > 180){
                    spawnBoss = true;
                    timer.stop();
                }
            }
        });
    }

    @Override
    protected void spawnEntities() {
        if (spawnBoss){
            System.out.println("Boss spawned!");
            spawn(new Asteroid1(new Coordinate2D(0,0)));
            spawnBoss = false;
        }
    }
}
