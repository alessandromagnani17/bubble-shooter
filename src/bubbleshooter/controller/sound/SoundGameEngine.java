package bubbleshooter.controller.sound;

import bubbleshooter.controller.engine.GameEngineDecorator;
import bubbleshooter.controller.engine.GameLoop;

public class SoundGameEngine extends GameEngineDecorator {

	private SoundManager soundManager = new SoundManager();
	
    public SoundGameEngine(final GameLoop gameLoop) {
        super(gameLoop);
        this.soundManager.loadBackgroundSound(SoundNames.COFFIN.getPath());
    }

	@Override
	public void startLoop() {
		super.startLoop();
		this.soundManager.startSound();
	}
	
	@Override
	public void stopLoop() {
        super.stopLoop();
        this.soundManager.stopSound();
	}
	
	@Override
	public void pauseLoop() {
        super.pauseLoop();
        this.soundManager.pauseSound();
	}
	
	@Override
	public void resumeLoop() {
        super.resumeLoop();
        this.soundManager.resumeSound();
	}
	
	public SoundManager getSoundManager() {
		return this.soundManager;
	}
	
	public GameLoop getGameEngine() {
		return super.gameLooop;
	}
}
