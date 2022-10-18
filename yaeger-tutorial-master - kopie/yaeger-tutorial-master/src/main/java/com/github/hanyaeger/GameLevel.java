package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private LaserSpawner laserSpawner;
    private  GameTimer timer;
    private TextEntity healthText = new TextEntity(new Coordinate2D(0, 0), String.valueOf(3));
    private TextEntity scoreText = new TextEntity(new Coordinate2D(0, 50), String.valueOf(0));

    private TextEntity timerText = new TextEntity(new Coordinate2D(0, 100), String.valueOf(0));
    private Main main;
    public GameLevel(Main main){
        this.main = main;

        timerText.setText("Timer: 0");
        timerText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        timerText.setFill(Color.LIGHTBLUE);

        timer = new GameTimer(timerText);
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/spaceship-ambience-with-effects-21420.mp3");
        setBackgroundImage("backgrounds/backgroundspace.jpg", true);
    }

    @Override
    public void setupEntities() {
        addEntity(healthText);
        addEntity(scoreText);
        addEntity(timerText);
        addEntity(new Player(new Coordinate2D(50, 0), healthText, scoreText, main, laserSpawner = new LaserSpawner(getWidth(), getHeight())));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(laserSpawner);
        addEntitySpawner(timer);
        addEntitySpawner(new AsteroidSpawner(400, getWidth()));
        timer.StartTimer();
    }
}

