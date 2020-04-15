package bubbleshooter.utility;

public enum GameCostants {

    ROWS(8),
    
    ROW_BUBBLE(17),
    
    RADIUS(19),
    
    BUBBLE_WIDTH(40), 
    
    BUBBLE_HEIGTH(40), 

    GUIWIDTH(705),

    GUIHEIGTH(700),

    BUBBLESPEED(0.1),

    FPS(60),
    
    CANNONHEIGTH(100), 
    
    CANNONWIDTH(1000),

    SECONDS(1000),
    
    GAMEOVERLINE(600);

    private double val;

    GameCostants(final double val) {
        this.val = val;
    }

    public double getValue() {
        return this.val;
    }
}
