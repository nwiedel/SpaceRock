package de.nicolas.utils.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseScreen implements Screen {

    protected Stage mainStage;
    protected Stage uiStage;

    public BaseScreen(){
        uiStage = new Stage();
        mainStage = new Stage();

        initialize();
    }

    public abstract void initialize();

    public abstract void update(float delta);

    public void render(float delta){
        mainStage.act(delta);
        uiStage.act(delta);

        update(delta);

        ScreenUtils.clear(0, 0, 0, 1);

        mainStage.draw();
        uiStage.draw();

    }
}
