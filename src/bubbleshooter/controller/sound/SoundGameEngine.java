package bubbleshooter.controller.sound;

import bubbleshooter.controller.engine.GameEngineDecorator;
import bubbleshooter.controller.engine.GameLoop;

public class SoundGameEngine extends GameEngineDecorator {

    public SoundGameEngine(final GameLoop gameLoop) {
        super(gameLoop);
    }

	@Override
	public void startLoop() {
		super.startLoop();
		Sound.playSound(SoundNames.BACKGROUND.getPath());
	}
	
	
	
}
