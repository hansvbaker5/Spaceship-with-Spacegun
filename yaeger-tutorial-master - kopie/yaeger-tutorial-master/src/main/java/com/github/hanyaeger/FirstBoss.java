//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.hanyaeger;

import com.github.hanyaeger.FirstBoss;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FirstBoss extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private int health = 20;
    private int bossSpeed = 2;
    private int counter = 0;
    private TextEntity bossHealthText = new TextEntity(new Coordinate2D(0.0, 550.0));
    private BossLaserSpawner bossLaser;
    private Main main;

    public FirstBoss(Coordinate2D location, Main main, BossLaserSpawner bossLaser) {
        super("sprites/boss.png", location, new Size(65.0, 65.0), 1, 4);
        this.main = main;
        this.bossLaser = bossLaser;
        this.setMotion((double)this.bossSpeed, 270.0);
        this.bossHealthText.setText("Boss HP: " + this.health);
        this.bossHealthText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30.0));
        this.bossHealthText.setFill(Color.DARKBLUE);
        this.setGravityConstant(0.005);
        this.setFrictionConstant(0.04);
    }

    public void notifyBoundaryTouching(SceneBorder border) {
//        switch (SceneBorder[border.ordinal()]) {
//            case Direction.LEFT:
//                this.setMotion((double)this.bossSpeed, Direction.RIGHT);
//                break;
//            case Direction.RIGHT:
//                this.setMotion((double)this.bossSpeed, Direction.LEFT);
//        }

    }

    public void onCollision(Collider collidingObject) {
        if (collidingObject.getClass().equals(LaserBeam.class)) {
            this.bossDamage();
        }

    }

    public void bossDamage() {
        if (this.health >= 0) {
            --this.health;
            ++this.counter;
            this.bossHealthText.setText("Boss HP: " + this.health);
            if (this.counter == 8) {
                ++this.bossSpeed;
                this.bossLaser.setFiringRate(200);
                this.counter = 0;
            }
        } else {
            System.out.println("YOU WON!");
            this.remove();
            this.main.setActiveScene(2);
        }

    }

    public void Shoot() {
        System.out.println("Boss Is Shooting");
        this.bossLaser.boss = this;
    }
}
