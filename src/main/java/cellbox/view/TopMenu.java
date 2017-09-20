package cellbox.view;

import cellbox.controller.ConLink;
import cellbox.model.arena.ArenaLink;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by luca on 18.09.17.
 */
public class TopMenu extends MenuBar {

    private ConLink controller;

    public TopMenu(ConLink controller) {
        Menu fileMenu = new Menu("File");
        Menu viewMenu = new Menu("View");
        Menu toolsMenu = new Menu("Tools");

        MenuItem makeCellTemplate = new MenuItem("Generate cell template...");
        MenuItem loadClass = new MenuItem("Load class...");
        MenuItem exit = new MenuItem("Close");

        exit.setOnAction(event -> {
            Platform.exit();
            event.consume();
        });

        loadClass.setOnAction(event -> {
            importFile();
            event.consume();
        });

        makeCellTemplate.setOnAction(event -> {
            makeNewTemplate();
        });

        fileMenu.getItems().addAll(makeCellTemplate, loadClass, exit);

        this.controller = controller;
        this.getMenus().addAll(fileMenu, viewMenu, toolsMenu);
    }

    private void importFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a class to import");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Java files", "*.java"));
        File selected = fileChooser.showOpenDialog(this.getScene().getWindow());

        if (selected.isFile())
            controller.importClass(selected);
    }

    private void makeNewTemplate() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Make a new cell template at:");
        File saveTo = fileChooser.showSaveDialog(this.getScene().getWindow());

        if (saveTo != null)
            controller.generateTemplate(saveTo);
        else
            System.out.println("No file specified");

    }

}
