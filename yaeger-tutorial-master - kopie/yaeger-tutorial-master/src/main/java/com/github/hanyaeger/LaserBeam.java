package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class LaserBeam extends DynamicSpriteEntity implements Collider, Collided {

    private Player player;

    public LaserBeam(Player player){
        super("sprites/Beam.png", new Coordinate2D(player.getAnchorLocation().getX() + 20, player.getAnchorLocation().getY()));
        this.player = player;
        setMotion(5, 180d);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().equals(Asteroid1.class)){
            //ADD POINT: 1
            player.GainScore(((Asteroid1) collider).point);
            ((Asteroid1) collider).remove();
            remove();
        }else if(collider.getClass().equals(Asteroid2.class)){
            //ADD POINT: 2
            player.GainScore(((Asteroid2) collider).point);
            ((Asteroid2) collider).remove();
            remove();
        }
    }
}