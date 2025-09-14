package de.nicolas;

import de.nicolas.screens.LevelScreen;
import de.nicolas.utils.game.BaseGame;

public class SpaceRock extends BaseGame {

    @Override
    public void create() {
        super.create();
        setActiveScreen(new LevelScreen());
    }
}
