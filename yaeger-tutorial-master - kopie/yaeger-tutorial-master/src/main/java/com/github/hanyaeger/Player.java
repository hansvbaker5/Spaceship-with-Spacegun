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
    public static int score = 0;
    private TextEntity healthText;
    public TextEntity scoreText;
    private  LaserSpawner laserSpawner;
    private Main main;

    public Player(Coordinate2D location, TextEntity healthText, TextEntity scoreText, Main main, LaserSpawner laserSpawner){
        super("sprites/spaceship1.png", location, new Size(40,80), 1, 4);

        this.main = main;

        this.laserSpawner = laserSpawner;
        this.healthText = healthText;
        this.scoreText = scoreText;

        score = 0;

        healthText.setText("Health: " + health);
        healthText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        healthText.setFill(Color.LIGHTBLUE);

        scoreText.setText("Score: " + score);
        scoreText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        scoreText.setFill(Color.LIGHTBLUE);


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
        healthText.setText("Health: " + health);

        if (health <= 0) {
            main.setActiveScene(2);
        }

    }

    public void GainScore(int point){
        score += point;
        scoreText.setText("Score: " + score);
    }

    public void Shoot(){
        System.out.println("Is Shooting");
        laserSpawner.player = this;
        laserSpawner.isShoot = true;
    }
}
