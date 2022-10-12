package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, KeyListener,
        SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private int health = 3;
    private  LaserSpawner laserSpawner;

    public Player(Coordinate2D location, int health, LaserSpawner laserSpawner){
        super("sprites/spaceship1.png", location, new Size(40,80), 1, 4);

        this.laserSpawner = laserSpawner;

        TextEntity healthText = new TextEntity(new Coordinate2D(0, 0), String.valueOf(health));
        healthText.setText("Health: " + health);
        healthText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        healthText.setFill(Color.DARKBLUE);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if(set.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            setCurrentFrameIndex(1);
        } else if(set.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            setCurrentFrameIndex(2);
        } else if(set.contains(KeyCode.UP)){
            setMotion(3,180d);
            setCurrentFrameIndex(0);
        } else if(set.contains(KeyCode.DOWN)){
            setMotion(3,0d);
            setCurrentFrameIndex(3);
        } else if(set.isEmpty()){
            setSpeed(0);
        }

        if (set.contains(KeyCode.X)){
            Shoot();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.getClass().equals(Asteroid1.class) || collider.getClass().equals(Asteroid2.class)){
            System.out.println("Hit!");
            Hurt();
            ((DynamicSpriteEntity) collider).remove();
        }
    }

    public void Hurt(){
        health--;

        if (health <= 0){
            System.out.println("You died!");
        }

    }

    public void Shoot(){
        System.out.println("Is Shooting");
        laserSpawner.playerLocation = new Coordinate2D(getAnchorLocation().getX() + 10, getAnchorLocation().getY() - 15);
        laserSpawner.isShoot = true;
    }
}
