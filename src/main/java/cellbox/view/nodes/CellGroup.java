package cellbox.view.nodes;

import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * Created by luca on 14.08.17.
 */
public class CellGroup extends AbstractGroup{

    private Polygon vision;
    private Cell cell;

    public CellGroup() {

        body = new Circle(15);
        body.setCenterX(0);
        body.setCenterY(0);
        body.setFill(Color.GREENYELLOW);
        body.setStrokeWidth(2);
        body.setStroke(Color.BLACK);

        Circle leftEye = new Circle(5);
        leftEye.setCenterX(-4.5);
        leftEye.setCenterY(14);
        leftEye.setFill(Color.WHITE);
        leftEye.setStrokeWidth(1);
        leftEye.setStroke(Color.BLACK);

        Circle rightEye = new Circle(7);
        rightEye.setCenterX(4);
        rightEye.setCenterY(14);
        rightEye.setFill(Color.WHITE);
        rightEye.setStrokeWidth(1);
        rightEye.setStroke(Color.BLACK);

        Circle leftEyeP = new Circle(1);
        leftEyeP.setCenterX(-4);
        leftEyeP.setCenterY(14.5);
        leftEyeP.setFill(Color.BLACK);

        Circle rightEyeP = new Circle(1);
        rightEyeP.setCenterX(4);
        rightEyeP.setCenterY(14);
        rightEyeP.setFill(Color.BLACK);

        vision = new Polygon();
        vision.getPoints().addAll(new Double[] {
                -4.0, 14.5,
                4.0, 14.0,
                50.0, 200.0,
                -50.0, 200.0
        });
        vision.setFill(Color.YELLOW);
        vision.setOpacity(0.3);

        this.getChildren().addAll(vision, body, leftEye, rightEye, leftEyeP, rightEyeP);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void showVision(boolean b) {
        vision.setVisible(b);
    }

    public Polygon getVision() {
        return vision;
    }

    public void rotate(double degree) {
        this.getTransforms().add(new Rotate(degree, 0, 0));
    }

    public Shape getBodyShape() {
        return body;
    }

}
