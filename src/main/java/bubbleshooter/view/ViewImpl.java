package bubbleshooter.view;

import bubbleshooter.controller.Controller;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.view.scene.SceneLoader;
import bubbleshooter.view.scene.SceneWrapper;
import bubbleshooter.view.scene.controller.AbstractController;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Implementation of {@link View}.
 *
 */
public class ViewImpl implements View {

	private static final String TITLE = "BUBBLE SHOOTER";
	private static final double WIDTH = Settings.getGuiWidth();
	private static final double HEIGTH = Settings.getGuiHeigth();
	private Controller controller;
	private AbstractController currentSceneController;
	private final Stage stage;
	private boolean viewStarted;

	public ViewImpl(final Stage startingStage) {
		this.stage = startingStage;
		this.viewStarted = false;
	}

	@Override
	public void launch(final Controller controller) {
		this.controller = controller;
		ImageLoader.loadAll();
		this.viewStarted = true;
		this.initialize();
	}

	private void initialize() {
		this.stage.setTitle(TITLE);
		this.stage.setMinHeight(HEIGTH);
		this.stage.setMinWidth(WIDTH);
		this.stage.setResizable(false);
		this.stage.setOnCloseRequest(e -> Runtime.getRuntime().exit(0));
		this.stage.show();
		this.loadScene(FXMLPath.MAIN);
	}

	@Override
	public void loadScene(final FXMLPath scene) {
		try {
			final SceneWrapper wrapper = SceneLoader.getLoader().getScene(scene);
			wrapper.getController().init(controller, this);
			this.currentSceneController = wrapper.getController();
			final Parent root = wrapper.getScene().getRoot();
			root.requestFocus();
			this.stage.setScene(wrapper.getScene());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		Platform.runLater(() -> this.currentSceneController.render());
	}

	@Override
	public void showGameOver() {
		this.currentSceneController.nextScene();
	}

}
