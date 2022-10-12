package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.Random;

public class LaserSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    public boolean isShoot = false;
    public Player player;

    public LaserSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        if (isShoot){
            spawn(new LaserBeam(player));
            new SoundClip("audio/blaster-2-81267.mp3").play();
            isShoot = false;
        }
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight);
    }
}
