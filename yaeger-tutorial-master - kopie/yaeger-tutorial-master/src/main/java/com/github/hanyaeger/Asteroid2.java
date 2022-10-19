package com.github.hanyaeger;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Asteroid2 extends Asteroid implements Collider, SceneBorderCrossingWatcher {
    protected Asteroid2(Coordinate2D initialLocation) {
        super("sprites/asteroidgray.png", initialLocation, new Size(50, 50), 2, 2);
    }

    @Override
    public void death() {
        new SoundClip("audio/explosion2.wav").play();
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
