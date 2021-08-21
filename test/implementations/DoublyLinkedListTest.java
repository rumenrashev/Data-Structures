package implementations;

import implementations.iterable.collections.linked.DoublyLinkedList;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        this.queue = new DoublyLinkedList<>();
    }

    @Test
    void addLast() {
        assertEquals(0, queue.size());
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertEquals(3, queue.size());
    }

    @Test
    void getFirst() {
        assertThrows(IllegalStateException.class, queue::getFirst);
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertEquals(1, queue.getFirst());
        assertEquals(1, queue.getFirst());
        assertEquals(3, queue.size());
    }

    @Test
    void removeFirst() {
        assertThrows(IllegalStateException.class, queue::removeFirst);
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertEquals(1, queue.removeFirst());
        assertEquals(2, queue.removeFirst());
        assertEquals(3, queue.removeFirst());
        assertThrows(IllegalStateException.class, queue::removeFirst);
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.addLast(1);
        assertEquals(1, queue.size());
        queue.addLast(2);
        assertEquals(2, queue.size());
        queue.addLast(3);
        assertEquals(3, queue.size());
        queue.removeFirst();
        assertEquals(2, queue.size());
        queue.removeFirst();
        assertEquals(1, queue.size());
        queue.removeFirst();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.addLast(1);
        assertFalse(queue.isEmpty());
        queue.removeFirst();
        assertTrue(queue.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(queue.contains(1));
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        assertTrue(queue.contains(1));
        assertTrue(queue.contains(2));
        assertTrue(queue.contains(3));
        assertFalse(queue.contains(4));
    }

    @Test
    void toArray() {
        assertArrayEquals(new Object[0], queue.toArray());
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, queue.toArray());
    }

    @Test
    void iterator() {
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void forEach() {
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        String expected = "123";
        final StringBuilder actual = new StringBuilder();
        queue.forEach(actual::append);
        assertEquals(expected, actual.toString());
    }
}
