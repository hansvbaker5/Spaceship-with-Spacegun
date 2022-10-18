package com.github.hanyaeger;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.media.SoundClip;

public class BossLaserSpawner extends EntitySpawner {

    public FirstBoss boss;
    private int firingRate = 1000;

    public BossLaserSpawner(double sceneWidth, double sceneHeight) {
        super(100);
    }

    @Override
    protected void spawnEntities() {
        while(boss.isVisible()) {
            try {
                wait(firingRate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spawn(new LaserBeam(boss));
            new SoundClip("audio/blaster-2-81267.mp3").play();
        }
    }

    public void setFiringRate(int firingRate) {
        this.firingRate += firingRate;
    }
}


