package com.github.hanyaeger;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private Main main;

    public TitleScene(Main main){
        this.main = main;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background4.png");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Spaceship with Spacegun"
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.VIOLET);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(waterworldText);

        var startButton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50), main
        );
        startButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(startButton);
    }
}
