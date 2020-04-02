package bubbleshooter.view.scene.controller;

import bubbleshooter.view.scene.FXMLPath;

public class GameController extends AbstractController {

    @Override
    public FXMLPath getNextScene() {
        return FXMLPath.MAIN; 
    }

    @Override
    protected FXMLPath getPreviousScene() {
        return FXMLPath.MAIN; 
    }

}