package interfaces.iterable.collections;

public interface Queue<E> extends Collection<E> {

    /**
     * adds an element last int the queue.
     *
     * @param element element to be pushed last in the queue.
     */
    void addLast(E element);

    /**
     * @return element the first element of the queue
     * @throws IllegalStateException if this queue is empty.
     */
    E getFirst();

    /**
     * Removes the first element of this queue
     * and returns element
     *
     * @return element first element of the queue
     * @throws IllegalStateException if this queue is empty.
     */
    E removeFirst();

}
