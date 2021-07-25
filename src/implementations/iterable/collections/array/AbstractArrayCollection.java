package implementations.iterable.collections.array;

import implementations.iterable.collections.AbstractCollection;

public abstract class AbstractArrayCollection<E> extends AbstractCollection<E> {


    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final int DEFAULT_RESIZE_COEFFICIENT = 2;

    protected E[] arr = createArray(DEFAULT_INITIAL_CAPACITY);

    protected void grow() {
        if (this.size == this.arr.length - 1) {
            E[] newArr = createArray(this.arr.length * DEFAULT_RESIZE_COEFFICIENT);
            if (this.size >= 0) {
                System.arraycopy(arr, 0, newArr, 0, this.size);
            }
            this.arr = newArr;
        }
    }

    private E[] createArray(int capacity){
        return (E[]) new Object[capacity];
    }


}
