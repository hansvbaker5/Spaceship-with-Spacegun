package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Asteroid2 extends DynamicSpriteEntity implements Asteroid, Collided {

    private final int speed = 2;

    protected Asteroid2(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        setMotion(speed, 180d);
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}
