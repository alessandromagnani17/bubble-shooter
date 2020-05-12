package bubbleshooter.view.scene;

public enum FXMLPath {

    /**
     * The main scene.
     */
    MAIN("/view/scenes/main.fxml"),

    /**
     * The game scene.
     */
    GAME("/view/scenes/game.fxml"),

    /**
     * The high score scene.
     */
    HIGHSCORE("/view/scenes/highscores.fxml"),

    /**
     * The game over scene.
     */
    GAMEOVER("/view/scenes/gameover.fxml"),

    /**
     * The pause scene.
     */
    PAUSE("/view/scenes/pause.fxml");

    private final String scene;

    FXMLPath(final String scene) {
        this.scene = scene;
    }

    public String getPath() {
        return this.scene;
    }
}
