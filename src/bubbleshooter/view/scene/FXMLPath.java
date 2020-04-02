package bubbleshooter.view.scene;

public enum FXMLPath {

    MAIN("/view/scenes/main.fxml"), 
    GAME("/view/scenes/game.fxml");

    private final String scene;

    FXMLPath(final String scene) {
        this.scene = scene;
    }

    public String getPath() {
        return this.scene;
    }
}
