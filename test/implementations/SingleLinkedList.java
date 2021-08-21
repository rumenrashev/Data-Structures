package implementations;

import implementations.iterable.collections.linked.SinglyLinkedList;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Stack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedList {

    private static final int SIZE = 100;
    private static final Integer LAST_ELEMENT = SIZE;
    private static Stack<Integer> stack;
    private static Stack<Integer> emptyStack;

    @BeforeAll
    static void init() {
        stack = new SinglyLinkedList<>();
        for (int i = 1; i <= SIZE; i++) {
            stack.addLast(i);
        }
        emptyStack = new SinglyLinkedList<>();
    }

    @Test
    void addLast_ShouldWorkCorrect() {
        assertEquals(SIZE, stack.size());
        assertEquals(LAST_ELEMENT, stack.getLast());
    }


    @Test
    void getLast_ShouldWork() {
        assertEquals(LAST_ELEMENT, stack.getLast());
    }

    @Test
    void getLast_ShouldThrowException() {
        assertThrows(
                IllegalStateException.class,
                () -> emptyStack.getLast());
    }

    @Test
    void removeLast_ShouldWorkCorrect() {
        assertEquals(SIZE, stack.size());
        assertEquals(LAST_ELEMENT, stack.removeLast());
        assertEquals(LAST_ELEMENT - 1, stack.getLast());
        assertEquals(SIZE - 1, stack.size());

        // Recover original stack
        init();
    }

    @Test
    void removeLast_ShouldThrowException() {
        assertThrows(
                IllegalStateException.class,
                () -> emptyStack.removeLast());
    }

    @Test
    void isEmptyShouldWorkCorrect() {
        assertTrue(emptyStack.isEmpty());
        assertFalse(stack.isEmpty());
    }

    @Test
    void containsShouldWorkCorrect() {
        assertFalse(emptyStack.contains(1));
        assertFalse(stack.contains(101));
        assertTrue(stack.contains(50));
    }

    @Test
    void toArrayShouldWorkCorrect() {
        Object[] expected = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, stack.toArray());
        expected = new Object[0];
        assertArrayEquals(expected, emptyStack.toArray());
    }

    @Test
    void iterator_ShouldWorkCorrect() {
        Iterator<Integer> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(LAST_ELEMENT, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(LAST_ELEMENT - 1, iterator.next());
        assertFalse(emptyStack.iterator().hasNext());
        // Recover original stack
        init();
    }

    @Test
    void forEach_ShouldSumAllNumbers() {
        AtomicInteger sum = new AtomicInteger();
        stack.forEach(e -> {
            sum.set(sum.get() + e);
        });
        assertEquals(5050, sum.get());
    }
}
