package bubbleshooter.view.scene;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public final class SceneLoader {
    
    private static final SceneLoader SINGLETON = new SceneLoader();

    /**
     * Singleton getter.
     * 
     * @return a new {@link SceneLoader}.
     */
    public static SceneLoader getLoader() {
        return SINGLETON;
    }

    /**
     * 
     * @param scene the {@link GameScenes} to be loaded.
     * @return a new {@link SceneWrapper} for the scene which will be loaded.
     * @throws IOException IOException
     */
    public SceneWrapper getScene(final FXMLPath scene) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        final Parent parent = FXMLLoader.load(getClass().getResource(scene.getPath()));
        return new SceneWrapperImpl(new Scene(parent), loader.getController());
    }

}