package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {
    private final double sceneWidth;

    protected AsteroidSpawner(long intervalInMs, double sceneWidth) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        if(new Random().nextInt(2) == 1 ){
            spawn(new Asteroid1(randomLocation()));
        } else {
            spawn(new Asteroid2(randomLocation()));
        }
    }

    private Coordinate2D randomLocation(){
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, -10);
    }
}
