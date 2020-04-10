package bubbleshooter.model.gameobject;

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
    public void setType(final GameObjectsTypes type) {
        this.type = type;
    }

    /*private List<Bubble> ammo;
    private Geometry shape;
    private Vector2D shootingDirection;

    public Cannon() {
     super.setPosition(new Coordinate(100, 100)); //DA MODIFICARE E METTERE A META' GUI
     super.setHeigth(30); //DA MODIFICARE CON ALTEZZA DEL CANNONE
     super.setWidth(20); //DA MODIFICARE CON LARGHEZZA DEL CANNONE
     this.shootingDirection = new Vector2D(super.getPosition());
    }

    public final void setShootingDirection(final Vector2D direction) {
        this.shootingDirection = direction;
    }
    
    public final Vector2D getShootingDirection() {
        return this.shootingDirection;
    }
    
    public final List<Bubble> getAmmo() {
       return this.ammo;
    }

    public final Bubble load() {
        // TO-DO !!!!!!
        return null;
    }

    public final Bubble shoot() {
        //TO-DO !!!!!!!!!!!!!!
        return null;
    }
    
    @Override
    public Geometry setCollisionBox() {
        final GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setWidth(super.getWidth());
        shapeFactory.setHeight(super.getHeight());
        return shapeFactory.createRectangle();
    }

    @Override
    public Geometry getCollisionBox() {
        return this.shape;
    }*/

}
