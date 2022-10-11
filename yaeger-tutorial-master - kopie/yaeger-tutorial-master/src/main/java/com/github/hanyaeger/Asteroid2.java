package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Asteroid2 extends DynamicSpriteEntity implements Asteroid, Collided {

    private final int speed = 3;

    protected Asteroid2(Coordinate2D initialLocation) {
        super("sprites/asteroidgray.png", initialLocation, new Size(50, 50));
        setMotion(speed, 0d);
    }

    @Override
    public void onCollision(Collider collider) {
        remove();

    }
}
