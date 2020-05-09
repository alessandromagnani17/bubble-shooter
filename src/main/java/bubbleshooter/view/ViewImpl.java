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
	private static final double MIN_WIDTH = Settings.getGuiWidth();
	private static final double MIN_HEIGHT = Settings.getGuiHeigth();
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
		this.initialize();
	}

	private void initialize() {
		this.stage.setTitle(TITLE);
		this.stage.setMinHeight(MIN_HEIGHT);
		this.stage.setMinWidth(MIN_WIDTH);
		this.stage.setOnCloseRequest(e -> Runtime.getRuntime().exit(0));
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
			Platform.runLater(() -> this.initStage(wrapper));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		Platform.runLater(() -> this.currentSceneController.render());
	}

	private void initStage(final SceneWrapper wrapper) {
		this.stage.setScene(wrapper.getScene());
		this.stage.setWidth(this.stage.getWidth());
		this.stage.setHeight(this.stage.getHeight());
		if (!this.viewStarted) {
			this.stage.setResizable(false);
			this.stage.show();
			this.viewStarted = true;
		}
	}

	@Override
	public void showGameOver() {
		this.currentSceneController.setGameover();
		this.currentSceneController.nextScene();

	}

}
