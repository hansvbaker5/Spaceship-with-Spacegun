package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private LaserSpawner laserSpawner;
    private TextEntity healthText = new TextEntity(new Coordinate2D(0, 0), String.valueOf(3));
    private TextEntity scoreText = new TextEntity(new Coordinate2D(0, 50), String.valueOf(0));
    private Main main;
    public GameLevel(Main main){
        this.main = main;
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
        addEntity(new Player(new Coordinate2D(50, 0), healthText, scoreText, main, laserSpawner = new LaserSpawner(getWidth(), getHeight())));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(laserSpawner);
        addEntitySpawner(new AsteroidSpawner(500, getWidth()));
    }
}

