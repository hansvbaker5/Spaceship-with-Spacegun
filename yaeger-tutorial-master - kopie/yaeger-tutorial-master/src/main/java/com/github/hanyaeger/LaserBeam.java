//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class LaserBeam extends DynamicSpriteEntity implements Collider, Collided {
    private Player player;
    private FirstBoss boss;

    public LaserBeam(Player player) {
        super("sprites/Beam.png", new Coordinate2D(player.getAnchorLocation().getX() + 20, player.getAnchorLocation().getY()));
        this.player = player;
        this.setMotion(5.0, 180.0);
    }

    public LaserBeam(FirstBoss boss) {
        super("sprites/Beam.png", boss.getAnchorLocation());
        this.boss = boss;
        this.setMotion(5.0, Direction.DOWN);
    }

    public void onCollision(Collider collider) {
        if (collider.getClass().equals(Asteroid1.class)) {
            this.player.GainScore(((Asteroid1)collider).getPoint());
            ((Asteroid1)collider).remove();
            this.remove();
        } else if (collider.getClass().equals(Asteroid2.class)) {
            this.player.GainScore(((Asteroid2)collider).getPoint());
            ((Asteroid2)collider).remove();
            this.remove();
        }

    }
}
