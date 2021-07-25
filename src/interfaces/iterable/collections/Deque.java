package interfaces.iterable.collections;

public interface Deque<E> extends Collection<E> {

    void addFirst(E element);

    void addLast(E element);

    E getLast();

    E getFirst();

    E removeFirst();

    E removeLast();

}
