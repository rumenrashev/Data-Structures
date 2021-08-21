package implementations.iterable.collections.linked.nodes;

public class SingleNode<E> extends Node<E> {

    private SingleNode<E> previous;

    public SingleNode(E element) {
        super(element);
    }

    public SingleNode<E> getPrevious() {
        return previous;
    }

    public SingleNode<E> setPrevious(SingleNode<E> previous) {
        this.previous = previous;
        return this;
    }
}
