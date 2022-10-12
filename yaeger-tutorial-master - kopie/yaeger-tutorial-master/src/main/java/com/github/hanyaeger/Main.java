package com.github.hanyaeger;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Main extends YaegerGame {


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Spaceship with Spacegun");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOver(this));
    }
}
