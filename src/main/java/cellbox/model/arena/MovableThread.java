package cellbox.model.arena;

import cellbox.model.element.Element;

import java.util.List;

/**
 * Created by luca on 16.09.17.
 */
public class MovableThread extends Thread {

    private List<Element> movables;

    public MovableThread(List<Element> movables) {
        this.movables = movables;
    }

    public void run() {
        for (Element m : movables) {
            m.tick();
        }
    }

}
