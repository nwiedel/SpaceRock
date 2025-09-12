package de.nicolas.utils.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import de.nicolas.utils.screens.BaseScreen;

/**
 * wird erstellt beim Start des Programms.
 * Steuert den Wechsel zwischen den Screens
 */
public abstract class BaseGame extends Game {

    /**
     * speichert die Referenz des aktuellen Game
     */
    private static BaseGame game;

    public BaseGame(){
        game = this;
    }

    @Override
    public void create() {
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);
    }

    /**
     * wird benutzt um zwischen den Screens zu wechseln
     * @param screen
     */
    public static void setActiveScreen(BaseScreen screen){
        game.setScreen(screen);
    }
}
