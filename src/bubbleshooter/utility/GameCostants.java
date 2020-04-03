package bubbleshooter.utility;

public enum GameCostants {

    ROWS(8),
    
    ROW_BUBBLE(15),
    
    RADIUS(28),
    
    BUBBLE_WIDTH(30),
    
    BUBBLE_HEIGTH(30),

    GUIWIDTH(1000),

    GUIHEIGTH(800),
    
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
