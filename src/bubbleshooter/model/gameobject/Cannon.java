package bubbleshooter.model.gameobject;

import bubbleshooter.utility.Utility;

import javafx.geometry.Point2D;

public class Cannon extends AbstractGameObject {
    
    private GameObjectsTypes type;
    
    public Cannon(final Point2D position) {
        super(position);
        this.type = GameObjectsTypes.CANNON; 
        this.initCannon();
    }

    @Override
	public final GameObjectsTypes getType() {
        return this.type;
    }

    @Override
	public final void setType(final GameObjectsTypes type) {
        this.type = type;
    }


    private void initCannon() {
        super.setType(GameObjectsTypes.CANNON);
        super.setPosition(Utility.getCannonpos());
     }

}
