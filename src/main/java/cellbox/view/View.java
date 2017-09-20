package cellbox.view;


import cellbox.controller.Controller;
import cellbox.model.arena.ArenaLink;
import cellbox.model.element.Element;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by luca on 29.08.17.
 */
public class View extends Region implements ViewLink {

    private Controller controller;
    private ArenaLink arena;

    private VBox root = new VBox();
    private Showgrounds showground = new Showgrounds();
    private GroupFactory factory = new GroupFactory();

    public View(Controller controller, ArenaLink arena) {

        this.controller = controller;
        this.arena = arena;
        this.getStylesheets().add("style/styleCSS.css");
        controller.registerView(this);
        setupChildren();

    }

    private void setupChildren() {

        ToolBar controlBar = new Controls(controller);
        MenuBar menuBar = new TopMenu(controller);

        root.getChildren().addAll(menuBar, showground, controlBar);
        this.getChildren().add(root);

    }

    public void addElements(List<Element> elements) {

        for (Object element : elements) {
            showground.addElement(factory.getNode((Element) element));
        }

    }

    public void addElement(Element e) {
        showground.addElement(factory.getNode(e));
    }

}
