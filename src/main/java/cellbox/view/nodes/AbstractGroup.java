package cellbox.view.nodes;

import cellbox.model.element.Element;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.awt.geom.Point2D;

/**
 * Created by luca on 29.08.17.
 */
public class AbstractGroup extends Group{

    Circle body;
    private Element link;
    private Point2D position;

    public AbstractGroup() {

    }

    public Element getLink() {
        return link;
    }

    public void setLink(Element link) {
        this.link = link;
    }

    public void setAngle(double angle) {
        this.getTransforms().add(new Rotate(- angle - 90, 0, 0));
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
