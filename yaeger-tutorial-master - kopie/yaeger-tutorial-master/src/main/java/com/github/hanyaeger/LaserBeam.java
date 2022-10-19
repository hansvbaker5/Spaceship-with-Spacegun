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
            player.GainScore(((Asteroid1) collider).getPoint());
            ((Asteroid1) collider).death();
            remove();
        }else if(collider.getClass().equals(Asteroid2.class)){
            //ADD POINT: 2
            player.GainScore(((Asteroid2) collider).getPoint());
            ((Asteroid2) collider).death();
            remove();
        }
    }
}