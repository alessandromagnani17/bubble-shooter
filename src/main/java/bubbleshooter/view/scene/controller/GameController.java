package bubbleshooter.view.scene.controller;

import bubbleshooter.controller.Controller;
import bubbleshooter.controller.input.HandlerAdapterMouseMoved;
import bubbleshooter.controller.input.SwitcherController;
import bubbleshooter.model.Model;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleType;
import bubbleshooter.utility.PhysicHelper;
import bubbleshooter.utility.Settings;
import bubbleshooter.view.View;
import bubbleshooter.view.cannon.Cannon;
import bubbleshooter.view.cannon.DrawCannon;
import bubbleshooter.view.cannon.DrawHelpLine;
import bubbleshooter.view.images.ImagePath;
import bubbleshooter.view.rendering.BubbleDrawer;
import bubbleshooter.view.scene.FXMLPath;
import bubbleshooter.view.states.GameState;
import bubbleshooter.view.states.InGameState;
import bubbleshooter.view.states.InPauseState;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class GameController extends AbstractController {

    private static final double MAXANGLE =  64.9;
    private static final double MINANGLE = -64.9;

    @FXML private Canvas canvas;
    @FXML private AnchorPane pane;
    @FXML private CheckBox helpCheckBox = new CheckBox("Help");
    @FXML private Button switchButton = new Button();

    private BubbleDrawer canvasDrawer;
    private boolean gameOver;
    private GameState currentState;
    private GameState inGameState;
    private GameState inPauseState;
    private DrawHelpLine help;
    private DrawCannon drawCannon;
    private Cannon cannon;
    private SwitcherController switcherController;
    private HandlerAdapterMouseMoved handlerAdapter;
    private Point2D startPointFirstLine;
    private Point2D shootingBubbleInitialPosition;

    @Override
    public final void init(final Controller controller, final View view) {
        super.init(controller, view);

        this.help  = new DrawHelpLine(this.pane);
        this.cannon = new Cannon(new Image(ImagePath.CANNON.getPath()));
        this.drawCannon = new DrawCannon(this.pane, this.cannon);
        this.startPointFirstLine = new Point2D(this.help.getHelpLine().getStartX(), this.help.getHelpLine().getStartY());
        this.handlerAdapter = new HandlerAdapterMouseMoved(this.drawCannon.getRotation(), this.help.getRotation(), 
                                        this.startPointFirstLine, this.help);

        this.pane.setOnMouseMoved(this.handlerAdapter);
        this.pane.setOnMouseDragged(this.handlerAdapter);
        this.pane.setOnMouseClicked(this.handlerAdapter);

        this.canvasDrawer = new BubbleDrawer(this.canvas);
        this.inGameState = new InGameState(this, controller);
        this.inPauseState = new InPauseState(this, controller);
        this.switcherController = new SwitcherController(this.getController().getBubbles());

        this.setCurrentState(this.inGameState);

        this.shootingBubbleInitialPosition = new Point2D(getController().getBubbles().stream()
                .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getX(), 
                getController().getBubbles().stream()
                .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get().getPosition().getY());

        this.pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(final MouseEvent event) {
                Bubble shootingBubble = getController().getBubbles().stream()
                        .filter(a -> a.getType().equals(BubbleType.SHOOTING_BUBBLE)).findFirst().get();
                if (shootingBubble.getPosition().getX() == shootingBubbleInitialPosition.getX() && checkAngle(handlerAdapter.getRotationAngle())) {
                    shootingBubble.setDirection(PhysicHelper.calculateShootingDirection(
                            new Point2D(event.getX()* ( Model.WORLD_WIDTH / Settings.getGuiWidth()) , event.getY() * (Model.WORLD_HEIGTH / Settings.getGuiHeigth())), shootingBubble.getPosition()));

                }
            }
        });
    }

    public final void render() {
        if (this.isGameOver()) {
            this.nextScene();
        }
        // da aggiungere anche la chiamata al controller per sapere lo score corrente
        this.resetCanvas();
        canvasDrawer.draw(this.getController().getBubbles());
    }

    public final void switchBall() {
        this.switcherController.switchControl();
        if (this.switcherController.isSwitchEnd()) {
            this.switchButton.setText("Ended");
            this.switchButton.setMouseTransparent(true);
        }
    }

    public final void helpSelected() {
        if (this.helpCheckBox.isSelected()) {
            this.help.drawLine();
        } else {
        	this.help.deleteLine();
        }
    }

    public final void pause() {
        this.getController().getGameEngine().pauseLoop();
        this.getView().loadScene(FXMLPath.PAUSE);
    }

    public final void restart() {
        this.getController().getGameEngine().pauseLoop();
        this.getController().startGame(this.getController().getCurrentLevel());
        this.getController().getGameEngine().resumeLoop();
        this.switcherController.setInitialNumSwitch();
        this.switchButton.setText("Switch");
        this.switchButton.setMouseTransparent(false);
    }

    @Override
    public final FXMLPath getNextScene() {
        return FXMLPath.GAMEOVER;
    }

    @Override
    protected final FXMLPath getPreviousScene() {
        return FXMLPath.MAIN;
    }

    public final boolean isGameOver() {
        return this.gameOver;
    }

    public final void setGameOver() {
        this.gameOver = true;
    }

    public final boolean checkAngle(final double angle) {
        return !(angle > MAXANGLE || angle < MINANGLE);
    }

    // Clear the canvas after every render. It avoids ghosting effect.
    private void resetCanvas() {
    	GraphicsContext gc = this.canvas.getGraphicsContext2D(); 
    	gc.restore();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.save();
        gc.scale(Settings.getGuiWidth()/Model.WORLD_WIDTH,Settings.getGuiHeigth() /  Model.WORLD_HEIGTH);
    }

    public final GameState getCurrentState() {
        return currentState;
    }

    public final void setCurrentState(final GameState state) {
        if (currentState != null) {
            this.currentState.exit();
        }
        this.currentState = state;
        this.currentState.enter();
    }

    public final GameState getInGameState() {
        return inGameState;
    }

    public final GameState getInPauseState() {
        return inPauseState;
    }
}
