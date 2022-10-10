package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    public GameLevel(){
    }

    @Override
    public void setupScene() {
//        setBackgroundAudio("audio/waterworld.mp3");
//        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
    }

    @Override
    public void setupEntitySpawners() {
    }
}

