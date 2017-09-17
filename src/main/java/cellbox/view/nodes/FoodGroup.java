package cellbox.view.nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Created by luca on 14.08.17.
 */
public class FoodGroup extends AbstractGroup {

    public FoodGroup() {
        body = new Circle(7);
        body.setCenterX(3.5);
        body.setCenterY(3.5);
        body.setFill(Color.RED);
        body.setStrokeWidth(2);
        body.setStroke(Color.BLACK);

        this.getChildren().add(body);
    }

    public Shape getBodyShape() {
        return body;
    }

}
