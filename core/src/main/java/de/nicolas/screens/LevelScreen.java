package de.nicolas.screens;

import com.badlogic.gdx.utils.compression.lzma.Base;
import de.nicolas.actors.Spaceship;
import de.nicolas.utils.actors.BaseActor;
import de.nicolas.utils.screens.BaseScreen;

public class LevelScreen extends BaseScreen {

    private Spaceship spaceShip;

    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0, 0, mainStage);
        space.loadTexture("assets/space.png");
        space.setSize(800, 600);
        BaseActor.setWorldBounds(space);

        spaceShip = new Spaceship(400, 300, mainStage);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public boolean keyDown(int i) {
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
