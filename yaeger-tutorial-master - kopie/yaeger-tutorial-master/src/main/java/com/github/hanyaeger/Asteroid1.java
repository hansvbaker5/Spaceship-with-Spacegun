package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Asteroid1 extends DynamicSpriteEntity implements Asteroid, Collider, SceneBorderCrossingWatcher {
    private final int speed = 2;
    public int point = 1;

    protected Asteroid1(Coordinate2D initialLocation) {
        super("sprites/asteroidbrown.png", initialLocation, new Size(50, 50));
        setMotion(speed, 0d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
