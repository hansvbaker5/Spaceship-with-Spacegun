package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private LaserSpawner laserSpawner;
    public GameLevel(){
    }

    @Override
    public void setupScene() {
//        setBackgroundAudio("audio/waterworld.mp3");
//        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(50, 0), 5, laserSpawner = new LaserSpawner(getWidth(), getHeight())));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(laserSpawner);
    }
}

