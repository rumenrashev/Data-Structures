package implementations;

import implementations.iterable.collections.linked.DoublyLinkedList;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Deque;

import java.util.NoSuchElementException;

public class DequeImpl<E> extends DoublyLinkedList<E> implements Deque<E> {

    @Override
    public void addFirst(E element) {
        ensureNotNull(element);
        Node<E> node = new Node<>(element);
        if (size == 0) {
            first = node;
            last = node;
        } else if (size == 1) {
            first = node;
            first.next = last;
            last.previous = first;
        } else {
            first.previous = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        ensureNotNull(element);
        Node<E> node = new Node<>(element);
        if (size == 0) {
            first = node;
            last = node;
        } else if (size == 1) {
            last = node;
            last.previous = first;
            first.next = last;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        return last.element;
    }

    @Override
    public E getFirst() {
        return first.element;
    }

    @Override
    public E removeFirst() {
        E element = this.getFirst();
        first = first.next;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        E element = this.getLast();
        last = last.previous;
        size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Deque is empty");
                }
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
