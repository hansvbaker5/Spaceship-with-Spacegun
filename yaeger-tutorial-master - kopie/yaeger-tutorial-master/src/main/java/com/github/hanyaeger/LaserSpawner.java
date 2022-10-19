package com.github.hanyaeger;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.Random;

public class LaserSpawner extends EntitySpawner {

    public boolean isShoot = false;
    public Player player;

    public LaserSpawner() {
        super(100);
    }

    @Override
    protected void spawnEntities() {
        if (isShoot){
            spawn(new LaserBeam(player));
            new SoundClip("audio/blaster-2-81267.mp3").play();
            isShoot = false;
        }
    }
}
