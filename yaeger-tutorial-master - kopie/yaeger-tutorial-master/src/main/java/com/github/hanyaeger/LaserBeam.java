package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class LaserBeam extends DynamicSpriteEntity implements Collider, Collided {

    public LaserBeam(Coordinate2D location){
        super("sprites/Beam.png", location);
        System.out.println("Pew");
        setMotion(5, 180d);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().equals(Asteroid1.class)){
            //ADD POINT: 1
            ((Asteroid1) collider).remove();
            remove();
        }else if(collider.getClass().equals(Asteroid2.class)){
            //ADD POINT: 2
            ((Asteroid2) collider).remove();
            remove();
        }
    }
}