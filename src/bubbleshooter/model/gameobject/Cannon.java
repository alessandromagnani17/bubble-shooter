package bubbleshooter.model.gameobject;

import bubbleshooter.utility.GameCostants;

import javafx.geometry.Point2D;

public class Cannon extends AbstractGameObject {
    
    private GameObjectsTypes type;
    
    public Cannon(Point2D position) {
        super(position);
        this.type = GameObjectsTypes.CANNON; 
        
    }

    @Override
    public void update(double elapsed) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public GameObjectsTypes getType() {
        return this.type;
    }

    @Override
    public void setType(GameObjectsTypes type) {
        this.type = type;
    }


    private void initCannon() {
        super.setType(GameObjectsTypes.CANNON);
        super.setPosition(new Point2D(0, GameCostants.GUIHEIGTH.getValue() - GameCostants.CANNONHEIGTH.getValue()));
        super.setHeigth(GameCostants.CANNONHEIGTH.getValue());
        super.setWidth(GameCostants.GUIWIDTH.getValue());
        }

}
