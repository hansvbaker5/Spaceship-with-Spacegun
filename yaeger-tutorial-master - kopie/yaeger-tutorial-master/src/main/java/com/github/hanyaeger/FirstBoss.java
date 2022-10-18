package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FirstBoss extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Newtonian, Collided, Collider {

    private int health = 20, bossSpeed = 2, counter = 0;
    private TextEntity bossHealthText = new TextEntity(new Coordinate2D(0, 550));
    private BossLaserSpawner bossLaser;
    private Main main;


    public FirstBoss(Coordinate2D location, Main main, BossLaserSpawner bossLaser) {
        super("sprites/boss.png", location, new Size(65, 65), 1, 4);

        this.main = main;
        this.bossLaser = bossLaser;

        setMotion(bossSpeed, 270d);

        bossHealthText.setText("Boss HP: " + health);
        bossHealthText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        bossHealthText.setFill(Color.DARKBLUE);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);

    }

    public void notifyBoundaryTouching(SceneBorder border) {

        switch (border) {
            case LEFT:
                setMotion(bossSpeed, Direction.RIGHT);
                break;
            case RIGHT:
                setMotion(bossSpeed, Direction.LEFT);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if(collidingObject.getClass().equals(LaserBeam.class)) {
            bossDamage();
        }
    }

    public void bossDamage() {
        if (health >= 0) {
            health--;
            counter++;
            bossHealthText.setText("Boss HP: " + health);
            if (counter == 8) {
                bossSpeed++;
                bossLaser.setFiringRate(200);
                counter = 0;
            }

        } else {
            System.out.println("YOU WON!");
            this.remove();
            main.setActiveScene(2);
        }
    }


    public void Shoot(){
        System.out.println("Boss Is Shooting");
        bossLaser.boss = this;
    }
}

