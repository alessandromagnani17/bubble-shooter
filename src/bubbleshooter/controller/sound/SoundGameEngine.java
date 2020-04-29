package bubbleshooter.controller.sound;

import bubbleshooter.controller.engine.GameEngineDecorator;
import bubbleshooter.controller.engine.GameLoop;

public class SoundGameEngine extends GameEngineDecorator {

    private final SoundManager soundManager = new SoundManager();

    public SoundGameEngine(final GameLoop gameLoop) {
        super(gameLoop);
        this.soundManager.loadBackgroundSound(SoundNames.COFFIN.getPath());
    }

    @Override
    public final void startLoop() {
        super.startLoop();
        this.soundManager.startSound();
    }

    @Override
    public final void stopLoop() {
        super.stopLoop();
        this.soundManager.stopSound();
    }

    @Override
    public final void pauseLoop() {
        super.pauseLoop();
        this.soundManager.pauseSound();
   }

    @Override
    public final void resumeLoop() {
        super.resumeLoop();
        this.soundManager.resumeSound();
    }

    public final SoundManager getSoundManager() {
        return this.soundManager;
    }
}
