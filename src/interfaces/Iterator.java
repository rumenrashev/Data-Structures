package interfaces;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public interface Iterator<E> {

    /**
     * @return {@code true} if the iteration has more elements,
     * {@code false} if the iteration has not more elements
     */
    boolean hasNext();

    /**
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    E next();
}
