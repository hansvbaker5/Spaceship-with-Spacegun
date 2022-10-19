package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public abstract class Asteroid extends DynamicSpriteEntity {
    private int point;
    public Asteroid(String resource, Coordinate2D initialLocation, Size size, int speed, int point) {
        super(resource, initialLocation, size);
        setMotion(speed, 0d);
        this.point = point;
    }

    public void death(){
        new SoundClip("audio/explosionStandard.mp3").play();
    }
    public int getPoint(){
        return point;
    }


}
