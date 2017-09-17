package cellbox.model.element;

import cellbox.Manager;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by luca on 13.08.17.
 */
public abstract class Element {

    private Point2D position;
    private double nutrients;
    private double angle;
    DoubleProperty xProperty = new SimpleDoubleProperty();
    DoubleProperty yProperty = new SimpleDoubleProperty();
    DoubleProperty angleProperty = new SimpleDoubleProperty();

    Element() {
        Random rnd = new Random();
        position = new Point2D.Double(
                rnd.nextInt((int)Manager.getShowgroundWidth()), rnd.nextInt((int)Manager.getShowgroundHeight()));
        this.angle = rnd.nextInt(360);

        xProperty.set(position.getX());
        yProperty.set(position.getY());
        angleProperty.set(angle + 45);

        System.out.println("Set movable to (" + getPosition().getX() + " / " + getPosition().getY() + ") " +
                " with angle " + getAngle());
    }

    Element(double x, double y, double angle, double nutrients) {
        position = new Point2D.Double(x, y);
        this.angle = angle;
        this.nutrients = nutrients;
    }

    public abstract void tick();

    public double getNutrients() { return nutrients; }

    public Point2D getPosition() {
        return position;
    }

    public double getAngle() {
        return angle;
    }

    public DoubleProperty getXProperty() {
        return xProperty;
    }

    public DoubleProperty getYProperty() {
        return yProperty;
    }

    public DoubleProperty getAngleProperty() {
        return angleProperty;
    }
}
