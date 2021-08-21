package interfaces.iterable.collections;

public interface List<E> extends Collection<E> {

    void add(E element);

    void add(int index, E element);

    void set(int index, E element);

    boolean remove(E element);

    E removeAt(int index);

    int indexOf(E element);

    int lastIndexOf(E element);

}
