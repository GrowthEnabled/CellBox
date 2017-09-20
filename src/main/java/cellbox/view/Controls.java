package cellbox.view;

import cellbox.controller.ConLink;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;

/**
 * Created by luca on 18.09.17.
 */
public class Controls extends ToolBar {

    public Controls(ConLink controller) {
        this.setPadding(new Insets(10));

        ToggleButton startBtn = new ToggleButton("Start");
        startBtn.setOnAction(event -> {
            if (startBtn.isSelected()) {
                startBtn.setText("Stop");
                controller.start();
            } else {
                startBtn.setText("Start");
                controller.stop();
            }
        });

        this.getItems().add(startBtn);
        
    }

}
