package bubbleshooter.controller.engine;

public class GameEngineDecorator implements GameLoop {

    /**
    * The BasicGameLoop used by the Decorator.
    */
    private GameLoop gameLooop;

    public GameEngineDecorator(final GameLoop gameLoop) {
        this.gameLooop = gameLoop;
    }

    /**
     * The method to Start the loop of the BasicGameLoop.
     */
    @Override
    public void startLoop() {
        this.gameLooop.startLoop();
    }

    /**
     * The method to Stop the loop of the BasicGameLoop.
     */
    @Override
    public void stopLoop() {
        this.gameLooop.stopLoop();
    }

    /**
     * The method to pause the loop of the BasicGameLoop.
     */
    @Override
    public void pauseLoop() {
        this.gameLooop.pauseLoop();
    }

    /**
     * The method to resume the loop of the BasicGameLoop.
     */
    @Override
    public void resumeLoop() {
        this.gameLooop.resumeLoop();
    }

	@Override
	public boolean isRunning() {
		return this.gameLooop.isRunning();
	}

	@Override
	public boolean isPaused() {
		return this.gameLooop.isPaused();
	}
}
