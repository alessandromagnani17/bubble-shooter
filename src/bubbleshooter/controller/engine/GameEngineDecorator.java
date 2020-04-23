package bubbleshooter.controller.engine;

public class GameEngineDecorator implements GameLoop{

    protected GameLoop gameLooop;
	
	public GameEngineDecorator(final GameLoop gameLoop) {
		this.gameLooop = gameLoop;
	}

	@Override
	public void startLoop() {
		this.gameLooop.startLoop();
	}

	@Override
	public void stopLoop() {
        this.gameLooop.stopLoop();
	}

	@Override
	public void pauseLoop() {
        this.gameLooop.pauseLoop();
	}

	@Override
	public void resumeLoop() {
        this.gameLooop.resumeLoop();
	}

}
