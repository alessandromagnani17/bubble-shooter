package bubbleshooter.view.scene;

public enum FXMLPath {

    MAIN("resources/view/scenes/main.fxml"),
    GAME("resources/view/scenes/game.fxml");
    
    private final String scene;

    
    FXMLPath(final String scene) {
        this.scene = scene;
    }
    
    public String getPath() {
        return this.scene;
    }
}
