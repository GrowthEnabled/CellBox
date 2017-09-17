package cellbox.view;


import cellbox.controller.Controller;
import cellbox.model.arena.ArenaLink;
import cellbox.model.element.Element;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * Created by luca on 29.08.17.
 */
public class View extends Region implements ViewLink{

    private Controller controller;
    private ArenaLink arena;

    private Pane root = new Pane();
    private Showgrounds showground = new Showgrounds();
    private GroupFactory factory = new GroupFactory();

    public View(Controller controller, ArenaLink arena) {
        this.controller = controller;
        this.arena = arena;
        controller.registerView(this);
        root.getChildren().add(showground);
        this.getChildren().add(root);
    }

    public void addElements(List<Element> elements) {

        for (Object element : elements) {
            showground.addElement(factory.getNode((Element)element));
        }

    }

}
