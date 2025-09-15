package de.nicolas.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.BaseActor;

public class Spaceship extends BaseActor {

    private Thruster thruster;
    private Shield shield;
    public int shieldPower;

    public Spaceship(float x, float y, Stage stage) {
        super(x, y, stage);

        loadTexture("assets/spaceship.png");
        setBoundaryPolygon(8);

        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);

        thruster = new Thruster(0, 0, stage);
        addActor(thruster);
        thruster.setPosition(-thruster.getWidth(),
            getHeight() / 2 -  thruster.getHeight() / 2);

        shield = new Shield(0, 0, stage);
        addActor(shield);
        shield.centerAtPosition(getWidth() / 2, getHeight() / 2);
        shieldPower = 100;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float degreesPerSecond = 120f;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            rotateBy(degreesPerSecond * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            rotateBy(-degreesPerSecond * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            accelerateAtAngle(getRotation());
            thruster.setVisible(true);
        }
        else {
            thruster.setVisible(false);
        }

        shield.setOpacity(shieldPower / 100f);
        if(shieldPower <= 0){
            shield.setVisible(false);
        }

        applyPhysics(delta);

        wrapAroundWorld();
    }

    public void wrapAroundWorld(){
        if (getX() + getWidth() < 0){
            setX(worldBounds.width);
        }
        if (getX() > worldBounds.width){
            setX(-getWidth());
        }
        if (getY() +getHeight() < 0){
            setY(worldBounds.height);
        }
        if (getY() > worldBounds.height){
            setY(-getHeight());
        }
    }
}
