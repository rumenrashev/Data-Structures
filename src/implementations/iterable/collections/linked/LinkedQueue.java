package implementations.iterable.collections.linked;

import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Queue;

public class LinkedQueue<E> extends DoublyLinkedList<E> implements Queue<E> {

    @Override
    public void push(E element) {
        super.addLast(element);
    }

    @Override
    public E peek() {
        return super.getFirst();
    }

    @Override
    public E poll() {
        return super.removeFirst();
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }
}
