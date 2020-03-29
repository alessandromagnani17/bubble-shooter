package bubbleshooter.view.scene.controller;

import bubbleshooter.model.gamemodality.LevelTypes;
import bubbleshooter.view.scene.FXMLPath;
/**
 * The Controller related to the main.fxml GUI.
 *
 */
public final class MainController extends AbstractController {
    /**
     * The handler for the click event generated by the 'btn' button.
     */
    
    public void btnOnClickHandler() {
            this.getController().startGame(LevelTypes.BASICMODE);
            this.nextScene();
    }

    @Override
    public FXMLPath getNextScene() {
        return FXMLPath.GAME; 
    }

    @Override
    protected FXMLPath getPreviousScene() {
        return FXMLPath.MAIN; 
    }
}
