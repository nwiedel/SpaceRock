package de.nicolas.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.BaseActor;

public class Spaceship extends BaseActor {

    public Spaceship(float x, float y, Stage stage) {
        super(x, y, stage);

        loadTexture("assets/spaceship.png");
        setBoundaryPolygon(8);

        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        
    }
}
