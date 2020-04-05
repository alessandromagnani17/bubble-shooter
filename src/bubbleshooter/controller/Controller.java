package bubbleshooter.controller;

import bubbleshooter.model.gamemodality.LevelTypes;

public interface Controller {

    void startGame(LevelTypes levelType);

    void pause();

    void resume();

    void setGameOver();

    //DATA MANAGER FOR SCORE

    //INPUT MANAGER

    //MUSIC 
}
