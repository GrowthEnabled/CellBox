package cellbox.view;

import cellbox.model.element.Element;
import cellbox.model.element.Movable;
import cellbox.view.nodes.AbstractGroup;
import cellbox.view.nodes.CellGroup;
import cellbox.view.nodes.FoodGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;

/**
 * Created by luca on 16.09.17.
 */
public class GroupFactory {

    public AbstractGroup getNode(Element e) {
        if (e instanceof Movable) {
            CellGroup cG = new CellGroup();
            cG.setLayoutX(e.getPosition().getX());
            cG.setLayoutY(e.getPosition().getY());
            cG.setAngle(e.getAngle());
            cG.setLink(e);
            System.out.println("Angle of the cell = " + e.getAngle());
            setupListeners(e, cG);
            System.out.println(e.getPosition().getX());
            System.out.println(e.getPosition().getY());
            return cG;
        } else {
            FoodGroup fG = new FoodGroup();
            fG.setLayoutX(e.getPosition().getX());
            fG.setLayoutX(e.getPosition().getY());
            return new FoodGroup();
        }
    }

    private void setupListeners(Element e, final AbstractGroup g){
        e.getXProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                g.setLayoutX((Double)newValue);
            }
        });
        e.getYProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                g.setLayoutY((Double)newValue);
            }
        });
        e.getAngleProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                g.setAngle((Double)newValue);
            }
        });
    }

}
