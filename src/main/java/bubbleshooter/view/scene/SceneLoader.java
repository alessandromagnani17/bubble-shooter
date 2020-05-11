package bubbleshooter.view.scene;

import java.io.IOException;

import bubbleshooter.view.scene.controller.AbstractController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public final class SceneLoader {

	private Scene scene;
	private AbstractController controller;

	public void loadScene(final FXMLPath scene) throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		final Parent parent = loader.load(getClass().getResourceAsStream(scene.getPath()));
		this.scene = new Scene(parent);
		this.controller = loader.getController();
	}

	public Scene getScene() {
		return scene;
	}

	public AbstractController getController() {
		return controller;
	}

}