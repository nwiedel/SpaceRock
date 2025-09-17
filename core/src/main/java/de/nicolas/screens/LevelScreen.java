package de.nicolas.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import de.nicolas.actors.Explosion;
import de.nicolas.actors.Rock;
import de.nicolas.actors.Spaceship;
import de.nicolas.utils.actors.BaseActor;
import de.nicolas.utils.screens.BaseScreen;
import com.badlogic.gdx.Input.Keys;

public class LevelScreen extends BaseScreen {

    private Spaceship spaceShip;

    private boolean gameOver;

    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0, 0, mainStage);
        space.loadTexture("assets/space.png");
        space.setSize(800, 600);
        BaseActor.setWorldBounds(space);

        spaceShip = new Spaceship(400, 300, mainStage);

        new Rock(600, 500, mainStage);
        new Rock(600, 300, mainStage);
        new Rock(600, 100, mainStage);
        new Rock(400, 100, mainStage);
        new Rock(200, 100, mainStage);
        new Rock(600, 300, mainStage);
        new Rock(600, 500, mainStage);
        new Rock(400, 500, mainStage);

        gameOver = false;
    }

    @Override
    public void update(float delta) {

        for (BaseActor rockActor : BaseActor.getList(mainStage, "de.nicolas.actors.Rock")){
            if (rockActor.overlaps(spaceShip)){
                if(spaceShip.shieldPower <= 0){
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(spaceShip);
                    spaceShip.remove();
                    spaceShip.setPosition(-1000, -10000);

                    BaseActor messageLoose = new BaseActor(0, 0, uiStage);
                    messageLoose.loadTexture("assets/message-lose.png");
                    messageLoose.centerAtPosition(400, 300);
                    messageLoose.setOpacity(0);
                    messageLoose.addAction(Actions.fadeIn(1));
                    gameOver = true;
                }
                else {
                    spaceShip.shieldPower -= 34;
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(rockActor);
                    rockActor.remove();
                }
            }
            for (BaseActor laserActor : BaseActor.getList(mainStage, "de.nicolas.actors.Laser")){
                if(laserActor.overlaps(rockActor)){
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                }
            }
        }
        if (!gameOver && BaseActor.count(mainStage, "de.nicolas.actors.Rock") == 0){
            BaseActor messageWin = new BaseActor(0, 0, uiStage);
            messageWin.loadTexture("assets/message-win.png");
            messageWin.centerAtPosition(400, 300);
            messageWin.setOpacity(0);
            messageWin.addAction(Actions.fadeIn(1));
            gameOver = true;
        }
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Keys.X){
            spaceShip.warp();
        }
        if (keycode == Keys.SPACE){
            spaceShip.shoot();
        }

        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
