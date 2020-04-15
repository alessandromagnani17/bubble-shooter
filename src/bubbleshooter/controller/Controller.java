package bubbleshooter.controller;

import java.util.List;

import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.model.gameobject.GameObject;

public interface Controller {

    void startGame(LevelTypes levelType);

    void pause();

    void resume();

    void setGameOver();
    
    List<GameObject> getGameObjects(); 

    //DATA MANAGER FOR SCORE

    //INPUT MANAGER

    //MUSIC 
}
