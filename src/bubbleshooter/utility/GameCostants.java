package bubbleshooter.utility;

public enum GameCostants {

    ROWS(8),
    
    ROW_BUBBLE(19),
    
    RADIUS(17),
    
    BUBBLE_WIDTH(36), 
    
    BUBBLE_HEIGTH(36), 

    GUIWIDTH(705),

    GUIHEIGTH(700),

    BUBBLESPEED(0.55),

    COLLISIONDISTANCE(31),
    
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
