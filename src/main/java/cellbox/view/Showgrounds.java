package cellbox.view;

import cellbox.Manager;
import cellbox.model.element.Movable;
import cellbox.view.nodes.AbstractGroup;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by luca on 29.08.17.
 */
public class Showgrounds extends Region{

    private Pane root = new Pane();
    private ObservableList elements = root.getChildren();

    public Showgrounds() {

        addMeasuringGrid();
        root.setMaxWidth(Manager.getShowgroundWidth());
        root.setMaxHeight(Manager.getShowgroundHeight());
        this.getChildren().add(root);

    }

    private void addMeasuringGrid() {

        for (long y = 100; y < Manager.getShowgroundHeight(); y += 100) {
            Line line = new Line(0, y, Manager.getShowgroundWidth(), y);
            root.getChildren().add(line);
        }

        for (long x = 100; x < Manager.getShowgroundWidth(); x += 100) {
            Line line = new Line(x, 0, x, Manager.getShowgroundHeight());
            root.getChildren().add(line);
        }

    }

    public void addElement(AbstractGroup group) {
        elements.add(group);
    }

    protected void layoutChildren() {

        super.layoutChildren();

        for (Object element : elements) {

            if (element instanceof AbstractGroup) {
                double y = Manager.getShowgroundHeight() - ((AbstractGroup) element).getLink().getPosition().getY();
                ((AbstractGroup) element).setLayoutY(y);
                System.out.println("Angle of the Group = " + ((AbstractGroup) element).getTransforms().get(0));
            }

        }

    }

}
