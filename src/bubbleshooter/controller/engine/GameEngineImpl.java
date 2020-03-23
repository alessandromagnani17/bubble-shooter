package bubbleshooter.controller.engine;

import bubbleshooter.model.Model;
import bubbleshooter.model.gamemodality.GameStatus;
import bubbleshooter.view.View;

public class GameEngineImpl extends Thread implements GameEngine  {

    public static final int FPS = 60;
    private static final int SECOND = 1000;
    private static final int PERIOD = SECOND / FPS;
    private final View view;
    private final Model model;
    private volatile boolean isRunning;
    private volatile boolean isPaused;
    private Thread loopThread;
    
    public GameEngineImpl(final View view, final Model model) {
        super();
        this.view = view;
        this.model = model;
        this.isRunning = false;
        this.isPaused=true;
    }

    @Override
    public void startLoop() {
        if (!this.isRunning()) {
            this.isRunning = true;
            this.isPaused = false;
            this.loopThread = new Thread(this ,"loop");
            this.loopThread.start();
        }
    }

    public void run(){
        long lastFrameTime = System.currentTimeMillis();
        while (this.isRunning()) {
            final long currentFrameTime = System.currentTimeMillis();
            //this.processInput();
            if (!this.isPaused()) {
                final long elapsed = currentFrameTime - lastFrameTime;
                this.updateAll(elapsed);
                this.waitForNextFrame(currentFrameTime);
            }
            lastFrameTime = currentFrameTime;
        }
        this.view.showGameOver();
        //musica gameover
        //score e classifica
    }

    @Override
    public final synchronized void stopLoop() {
        this.isRunning = false;
        this.loopThread.interrupt(); // per fermare il thread se si trova in sleep
    }
    
    @Override
    public final synchronized void pauseLoop() {
        this.isPaused = true;
    }
    
    @Override
    public final synchronized void resumeLoop() {
        this.isPaused = true;
    }
    
    private boolean isPaused() {
        return this.isPaused || this.model.getGameStatus().equals(GameStatus.PAUSE);
    }
    
    private boolean isRunning() {
        return this.isRunning;
    }
    
    private void waitForNextFrame(final long currentFrameTime) {
       long sleepTime;
       long remainingTime = this.PERIOD - currentFrameTime;
       if (remainingTime < 0) {
            sleepTime = PERIOD; 
       }else {
           sleepTime = remainingTime; 
       }
       try {
           Thread.sleep(sleepTime);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
    
    private void updateAll(final double elapsed) {
        this.model.update(elapsed);
        //this.view.update();
    }
}
