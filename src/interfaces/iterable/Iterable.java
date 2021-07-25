package interfaces.iterable;

import interfaces.iterable.Iterator;

import java.util.function.Consumer;

public interface Iterable<E> {

    /**
     * @return  an iterator over elements of type {@code E}.
     */
    Iterator<E> iterator();

    /**
     * Performs the given action for each element of the {@code Iterable}
     * @param action to be performed
     * @throws NullPointerException if action is Null
     */
    void forEach(Consumer<E> action);

}
