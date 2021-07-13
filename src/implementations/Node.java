package implementations;

public class Node<E> {

    private E element;
    private Node<E> next;

    public Node() {
    }

    public E getElement() {
        return element;
    }

    public Node<E> setElement(E element) {
        this.element = element;
        return this;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> setNext(Node<E> next) {
        this.next = next;
        return this;
    }
}
