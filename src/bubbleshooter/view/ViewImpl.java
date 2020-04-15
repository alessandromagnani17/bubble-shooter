package bubbleshooter.view;

import bubbleshooter.controller.Controller;
import bubbleshooter.utility.GameCostants;
import bubbleshooter.view.images.ImageLoader;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.view.scene.SceneLoader;
import bubbleshooter.view.scene.SceneWrapper;
import bubbleshooter.view.scene.controller.AbstractController;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ViewImpl implements View {

    private static final String TITLE = "BUBBLE SHOOTER";
    private Controller controller;
    private AbstractController currentGuiController;
    private final Stage stage;
    private boolean viewStarted;

    public ViewImpl(final Stage startingStage) {
        super();
        this.stage = startingStage;
        this.viewStarted = false;
    }

    @Override
    public void launch(final Controller controller) {
      this.controller = controller;
      this.initalize();
      ImageLoader.getLoader().loadAll();
    }

    private void initalize() {
        this.stage.setTitle(TITLE);
        this.stage.setMaximized(false);
        this.stage.setOnCloseRequest(e -> Runtime.getRuntime().exit(0));
        this.loadScene(FXMLPath.MAIN);
    }

    @Override
    public void loadScene(final FXMLPath scene) {
        try {
            final SceneWrapper wrapper = SceneLoader
                    .getLoader()
                    .getScene(scene);
            wrapper.getController().init(controller, this);
            this.currentGuiController = wrapper.getController();

            final Parent root = wrapper.getScene().getRoot();
            root.requestFocus();
            //root.setOnKeyPressed(wrapper.getController()::onKeyPressed);
            Platform.runLater(() -> this.initStage(wrapper));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public final void render() {
        Platform.runLater(() -> this.currentGuiController.render());
    }

    private void initStage(final SceneWrapper wrapper) {
       // final double oldWidth = this.stage.getWidth();
       // final double oldHeigth = this.stage.getHeight();
        this.stage.setScene(wrapper.getScene());
        this.stage.setWidth(GameCostants.GUIWIDTH.getValue());
        this.stage.setHeight(GameCostants.GUIHEIGTH.getValue());

        if (!this.viewStarted) {
            this.stage.setResizable(false);
            this.stage.show();
            this.viewStarted = true;
        }
    }

    @Override
    public void showGameOver() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
       this.render();
    }

 
}

