package implementations.iterable.collections.linked;

import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Stack;

public class LinkedStack<E> extends SinglyLinkedList<E> implements Stack<E> {

    @Override
    public void push(E element) {
        super.addLast(element);
    }

    @Override
    public E peek() {
        return super.getLast();
    }

    @Override
    public E pop() {
        return super.removeLast();
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }
}
