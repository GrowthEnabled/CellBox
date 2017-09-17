package cellbox.model.arena;

import cellbox.model.element.Element;
import cellbox.model.element.Movable;
import cellbox.view.ViewLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 29.08.17.
 */
public class Arena implements ArenaLink {

    private List<MovableThread> threads = new ArrayList<MovableThread>();
    private int maxThreads;
    private ViewLink view;

    public Arena(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public void tick() {
        for (MovableThread mT : threads) {
            mT.run();
        }
    }

    public void populate(int count, Class<Movable> movableClass) {

        for (int t = 0; t < maxThreads; t++) {

            List<Element> movables = new ArrayList<Element>();

            int elems = getElemsInThread(count, t);

            for (int i = 0; i < elems; i++) {

                try {

                    movables.add(movableClass.newInstance());
                    if (elems * maxThreads < count
                            && t == maxThreads - 1) {
                        movables.add(movableClass.newInstance());
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            MovableThread thread = new MovableThread(movables);
            view.addElements(movables);
            threads.add(thread);
        }
    }

    public void registerView(ViewLink view) {
        this.view = view;
    }

    private int getElemsInThread(int count, int index) {
        if (index < maxThreads - 1)
            return count / maxThreads;
        else
            return count / maxThreads + count % maxThreads;
    }

}
