package com.github.hanyaeger;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {

    private Main main;

    public GameOver(Main main){this.main = main;}

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/space.jpg");
    }

    @Override
    public void setupEntities() {
        var gameoverText = new TextEntity(
                new Coordinate2D(getWidth() /2, getHeight() / 2),
                "Game Over"
        );

        gameoverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameoverText.setFill(Color.WHITE);
        gameoverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(gameoverText);

        var startButton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50), main
        );
        startButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(startButton);


        var scoreText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 - 70),
                "Score: " + Player.score
        );

        scoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        scoreText.setFill(Color.BLUE);
        scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(scoreText);



    }
}
