package de.nicolas.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.BaseActor;

public class Thruster extends BaseActor {

    public Thruster(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("assets/fire.png");
    }
}
