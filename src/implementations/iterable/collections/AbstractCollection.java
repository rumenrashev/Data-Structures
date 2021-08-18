package implementations.iterable.collections;

import interfaces.iterable.collections.Collection;
import interfaces.iterable.Iterator;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public abstract class AbstractCollection<E> implements Collection<E> {

    protected int size;

    protected AbstractCollection() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size > 0;
    }

    protected void ensureNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
    }

    protected void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Collection is empty.");
        }
    }

    public E[] toArray() {
        E[] arr = (E[]) new Object[size];
        Iterator<E> iterator = iterator();
        int ind = 0;
        while (iterator.hasNext()) {
            arr[ind++] = iterator.next();
        }
        return arr;
    }

    public boolean contains(E element) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<E> action) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }
}
