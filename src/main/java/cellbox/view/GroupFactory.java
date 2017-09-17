package cellbox.view;

import cellbox.model.element.Element;
import cellbox.model.element.Movable;
import cellbox.view.nodes.AbstractGroup;
import cellbox.view.nodes.CellGroup;
import cellbox.view.nodes.FoodGroup;

/**
 * Created by luca on 16.09.17.
 */
public class GroupFactory {

    public AbstractGroup getNode(Element e) {
        if (e instanceof Movable) {
            CellGroup cG = new CellGroup();
            cG.setTranslateX(0);
            cG.setTranslateY(0);
            cG.layoutXProperty().bind(e.getXProperty());
            cG.layoutYProperty().bind(e.getYProperty());
            System.out.println(e.getPosition().getX());
            System.out.println(e.getPosition().getY());
            cG.rotateProperty().bind(e.getAngleProperty());
            return cG;
        } else {
            FoodGroup fG = new FoodGroup();
            fG.setLayoutX(e.getPosition().getX());
            fG.setLayoutX(e.getPosition().getY());
            return new FoodGroup();
        }
    }

}
