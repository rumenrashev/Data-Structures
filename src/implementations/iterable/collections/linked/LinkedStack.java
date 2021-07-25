package implementations.iterable.collections.linked;

import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> extends AbstractSinglyLinkedCollection<E> implements Stack<E> {

    private Node<E> last;

    @Override
    public void push(E element) {
        ensureNotNull(element);
        Node<E> node = new Node<>(element);
        if (last != null) {
            node.next = last;
        }
        last = node;
        size++;
    }

    @Override
    public E peek() {
        ensureNotEmpty();
        return last.element;
    }

    @Override
    public E pop() {
        E element = peek();
        last = last.next;
        size--;
        return element;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(current == null )
                    throw new NoSuchElementException("Stack is empty.");
                E element = this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}
