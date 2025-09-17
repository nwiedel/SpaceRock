package de.nicolas.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
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

    public void warp(){
        if (getStage() == null){
            return;
        }
        Warp warp1 = new Warp(0, 0, this.getStage());
        warp1.centerAtActor(this);
        setPosition(MathUtils.random(800), MathUtils.random(600));
        Warp warp2 = new Warp(0, 0, this.getStage());
        warp2.centerAtActor(this);
    }

    public void shoot(){
        if (getStage() == null){
            return;
        }

        Laser laser = new Laser(0, 0, this.getStage());
        laser.centerAtActor(this);
        laser.setRotation(this.getRotation());
        laser.setMotionAngle(this.getRotation());
    }
}
