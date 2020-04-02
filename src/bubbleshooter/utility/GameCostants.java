package bubbleshooter.utility;

public enum GameCostants {

    RADIUS(30),

    GUIWIDTH(1000),

    GUIHEIGTH(800),
    
    BUBBLESPEED(0.1),

    FPS(60),
    
    CANNONHEIGTH(100), 
    
    CANNONWIDTH(1000),

    SECONDS(1000);

    private double val;

    GameCostants(double val) {
        this.val = val;
    }

    public double getValue() {
        return this.val;
    }
}
