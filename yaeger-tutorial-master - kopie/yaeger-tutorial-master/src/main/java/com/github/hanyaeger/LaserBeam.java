package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class LaserBeam extends DynamicSpriteEntity {

    public LaserBeam(Coordinate2D location){
        super("sprites/Beam.png", location);
        System.out.println("Pew");
        setMotion(5, 180d);
    }
}