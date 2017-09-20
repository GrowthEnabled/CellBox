package cellbox.model.arena;

import cellbox.model.element.Movable;

import java.io.File;

/**
 * Created by luca on 29.08.17.
 */
public interface ArenaLink {

    void tick();
    void populate(int count, Class<Movable> movableClass);
    void loadClass(File selected);

}
