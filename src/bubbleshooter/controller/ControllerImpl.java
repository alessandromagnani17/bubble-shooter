package bubbleshooter.controller;

import bubbleshooter.model.Model;
import bubbleshooter.view.View;

public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    
    
    public ControllerImpl(final Model model, final View view) {
     this.model = model;
     this.view = view;
    }

    @Override
    public void startGame() {
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setGameOver() {
        // TODO Auto-generated method stub
        
    }
    
}
