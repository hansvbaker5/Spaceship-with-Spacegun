//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.hanyaeger;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.media.SoundClip;

public class BossLaserSpawner extends EntitySpawner {
    public FirstBoss boss;
    private int firingRate = 1000;

    public BossLaserSpawner(double sceneWidth, double sceneHeight) {
        super(100L);
    }

    protected void spawnEntities() {
        while(this.boss.isVisible()) {
            try {
                this.wait((long)this.firingRate);
            } catch (InterruptedException var2) {
                throw new RuntimeException(var2);
            }

            this.spawn(new LaserBeam(this.boss));
            (new SoundClip("audio/blaster-2-81267.mp3")).play();
        }

    }

    public void setFiringRate(int firingRate) {
        this.firingRate += firingRate;
    }
}
