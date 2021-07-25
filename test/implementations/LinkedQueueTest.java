package implementations;

import implementations.iterable.collections.linked.LinkedQueue;
import interfaces.iterable.Iterator;
import interfaces.iterable.collections.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        this.queue = new LinkedQueue<>();
    }

    @Test
    void push() {
        assertEquals(0, queue.size());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(3, queue.size());
    }

    @Test
    void peek() {
        assertThrows(NoSuchElementException.class, queue::peek);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    void poll() {
        assertThrows(NoSuchElementException.class, queue::poll);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertThrows(NoSuchElementException.class, queue::poll);
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.push(1);
        assertEquals(1, queue.size());
        queue.push(2);
        assertEquals(2, queue.size());
        queue.push(3);
        assertEquals(3, queue.size());
        queue.poll();
        assertEquals(2, queue.size());
        queue.poll();
        assertEquals(1, queue.size());
        queue.poll();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(queue.contains(1));
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertTrue(queue.contains(1));
        assertTrue(queue.contains(2));
        assertTrue(queue.contains(3));
        assertFalse(queue.contains(4));
    }

    @Test
    void toArray() {
        assertArrayEquals(new Object[0], queue.toArray());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, queue.toArray());
    }

    @Test
    void iterator() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1,iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2,iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3,iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void forEach() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        String expected = "123";
        final StringBuilder actual = new StringBuilder();
        queue.forEach(actual::append);
        assertEquals(expected,actual.toString());
    }
}
