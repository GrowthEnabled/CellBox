package cellbox.model.arena;

import cellbox.model.element.Movable;

/**
 * Created by luca on 29.08.17.
 */
public interface ArenaLink {

    public void tick();
    public void populate(int count, Class<Movable> movableClass);

}
