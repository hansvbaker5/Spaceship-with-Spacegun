package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private int health;

    public Player(Coordinate2D location, int health){
        super("sprites/Spaceship.png", location, new Size(40,80), 1, 4);

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
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void onCollision(Collider collider) {
    }

    public void Hurt(){
        setAnchorLocation(
                new Coordinate2D(new Random().nextInt((int)(getSceneWidth()
                        - getWidth())),
                        new Random().nextInt((int)(getSceneHeight() - getHeight())))
        );

        health--;

    }
}
