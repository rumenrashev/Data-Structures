package implementations.iterable.collections.linked;

import implementations.iterable.collections.AbstractCollection;
import interfaces.iterable.Iterator;

public class DoublyLinkedList<E> extends AbstractCollection<E> {

    protected static class Node<E> {
        public E element;
        public Node<E> previous;
        public Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public Node<E> first;
    public Node<E> last;

    public void addLast(E element) {
        Node<E> node = new Node<>(element);
        if (super.size == 0) {
            this.first = node;
            this.last = node;
        } else if (super.size == 1) {
            this.last = node;
            this.last.previous = this.first;
            this.first.next = this.last;
        } else {
            this.last.next = node;
            node.previous = this.last;
            this.last = node;
        }
        this.size++;
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>(element);
        if (super.size == 0) {
            this.first = node;
            this.last = node;
        } else if (super.size == 1) {
            this.first = node;
            this.first.next = this.last;
            this.last.previous = this.first;
        } else {
            this.first.previous = node;
            node.next = this.first;
            this.first = node;
        }
        this.size++;
    }

    public E getFirst() {
        ensureNotEmpty();
        return first.element;
    }

    public E getLast() {
        ensureNotEmpty();
        return last.element;
    }

    public E removeFirst() {
        E element = getFirst();
        if (super.size == 1) {
            this.first = null;
            this.last = null;
        } else if (super.size == 2) {
            this.last.previous = null;
            this.first = this.last;
        } else {
            this.first = first.next;
        }
        this.size--;
        return element;
    }


    public E removeLast() {
        E element = getLast();
        if (super.size == 1) {
            this.first = null;
            this.last = null;
        } else if (super.size == 2) {
            this.first.next = null;
            this.last = this.first;
        } else {
            this.last = this.last.previous;
        }
        this.size--;
        return element;
    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
