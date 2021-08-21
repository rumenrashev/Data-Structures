package implementations.iterable.collections.linked.nodes;

public class Node<E> {

    private E element;

    protected Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public Node<E> setElement(E element) {
        this.element = element;
        return this;
    }
}
