package interfaces;

public interface Queue<E> extends Collection<E> {

    /**
     * Pushes an element last int the queue.
     * @param   element element to be pushed last in the queue.
     */
    void push(E element);

    /**
     * @return element the first element of the queue
     * @throws  IllegalStateException  if this queue is empty.
     */
    E peek();

    /**
     * Removes the first element of this queue
     * and returns element
     * @return element first element of the queue
     * @throws  IllegalStateException  if this queue is empty.
     */
    E poll();

}
