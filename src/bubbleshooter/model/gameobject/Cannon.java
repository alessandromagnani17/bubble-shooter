package bubbleshooter.model.gameobject;

import java.util.LinkedList;

import java.util.List;


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.math.Vector2D;
import org.locationtech.jts.util.GeometricShapeFactory;

import bubbleshooter.view.images.Color;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Cannon extends AbstractGameObject implements GameObject {

    private List<ShootingBubble> ammo;
    private Rectangle shape;
    private Point2D shootingDirection;
    private ShootingBubble readyToShoot;
    private double angle;
    private double bubbleSpeed = 0.1;
    private double xVel, yVel;

    public Cannon() {
     super.setType(GameObjectsTypes.CANNON);
     super.setPosition(new Point2D(50, 0)); //DA MODIFICARE E METTERE A META' GUI
     super.setHeigth(30); //DA MODIFICARE CON ALTEZZA DEL CANNONE -- UTILE PER COLLISION BOX
     super.setWidth(20); //DA MODIFICARE CON LARGHEZZA DEL CANNONE - UTILE PER COLLISION BOX
     this.shape = new Rectangle(super.getPosition().getX(),super.getPosition().getY(), super.getWidth(), super.getHeight()) ;
     this.readyToShoot = new ShootingBubble(super.getPosition(), Color.getRandomColor());
     this.ammo = new LinkedList<ShootingBubble>();
     this.initAmmo();
    }

    private void initAmmo() {
        this.readyToShoot = new ShootingBubble(super.getPosition(), Color.getRandomColor());
        this.ammo.add(new ShootingBubble(super.getPosition(), Color.getRandomColor()));
        this.ammo.add(new ShootingBubble(super.getPosition(), Color.getRandomColor()));
        this.ammo.add(new ShootingBubble(super.getPosition(), Color.getRandomColor()));
    }

    public final List<ShootingBubble> getAmmo() {
       return this.ammo;
    }

    public final void load() {
        this.readyToShoot = this.ammo.stream().iterator().next();
        this.ammo.add(new ShootingBubble(super.getPosition(), Color.getRandomColor()));
    }

    public final void update(final double elapsed){
       //DOPO IL CLICK DEL MOUSE NELLA GUI SI CHIAMA IL METODO SHOOT CHE IMPOSTA LA DIREZIONE POI 
       //SI FA PARTIRE IL GAME LOOP CHE RICHIAMA UPDATE OGNI TOT MS E IN QUESTO METODO 
       //BISOGNA AGGIORNARE LA POSIZIONE DELLA SHOOTING BUBBLE A SECONDA DELLA DIREZIONE IMPOSTATA
       this.readyToShoot.update(elapsed);
    }

    //VIENE INVOCATO CON IL CLICK DEL MOUSE NELLA GUI MA ALLO STESSO TEMPO PARTE ANCHE IL GAME LOOP
    // CHE FA FARE UPDATE 
    public final void shoot(final Point2D mousePosition) {
        this.shootingDirection = mousePosition;
        this.angle = Math.atan2(this.shootingDirection.getY(), this.shootingDirection.getX());
        this.xVel = bubbleSpeed * Math.cos(angle);
        this.yVel = bubbleSpeed * Math.sin(angle);
        this.readyToShoot.setDirection(new Point2D(this.xVel, this.yVel));
        this.load();
    }


    @Override
    public Shape getShape() {
        return this.shape;
    }

}
