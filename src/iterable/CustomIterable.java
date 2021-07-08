package iterable;

import java.util.Iterator;
import java.util.function.Consumer;

public interface CustomIterable<E> {
    /**
     * @return Iterator
     */
    Iterator<E> iterator();

    /**
     * @param action
     * applies action to every element
     */
    void forEach(Consumer<E> action);


}
