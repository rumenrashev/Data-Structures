package implementations.iterable.collections.linked.nodes;

public class DoubleNode<E> extends Node<E> {

    private DoubleNode<E> next;
    private DoubleNode<E> previous;

    public DoubleNode(E element) {
        super(element);
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public DoubleNode<E> setNext(DoubleNode<E> next) {
        this.next = next;
        return this;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public DoubleNode<E> setPrevious(DoubleNode<E> previous) {
        this.previous = previous;
        return this;
    }
}
