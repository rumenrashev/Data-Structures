package implementations;

import interfaces.Iterator;
import interfaces.Stack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

class ArrayStackTest {

    private static final int SIZE = 100;
    private static final Integer LAST_ELEMENT = SIZE;
    private static Stack<Integer> stack;
    private static Stack<Integer> emptyStack;

    @BeforeAll
    static void init(){
        stack = new ArrayStack<>();
        for (int i = 1; i <= SIZE; i++) {
            stack.push(i);
        }
        emptyStack = new ArrayStack<>();
    }

    @Test
    void push_ShouldWorkCorrect() {
        assertEquals(SIZE, stack.size());
        assertEquals(LAST_ELEMENT, stack.peek());
    }

    @Test
    void push_ShouldThrowNullPointerException(){
        assertThrows(
                NullPointerException.class,
                ()-> stack.push(null));
    }

    @Test
    void peek_ShouldWork(){
        assertEquals(LAST_ELEMENT, stack.peek());
    }

    @Test
    void peek_ShouldThrowException(){
        assertThrows(
                IllegalStateException.class,
                ()-> emptyStack.peek());
    }

    @Test
    void pop_ShouldWorkCorrect(){
        assertEquals(SIZE,stack.size());
        assertEquals(LAST_ELEMENT,stack.pop());
        assertEquals(LAST_ELEMENT - 1,stack.peek());
        assertEquals(SIZE - 1, stack.size());

        // Recover original stack
        init();
    }

    @Test
    void pop_ShouldThrowException(){
        assertThrows(
                IllegalStateException.class,
                ()-> emptyStack.pop());
    }

    @Test
    void isEmptyShouldWorkCorrect(){
        assertTrue(emptyStack.isEmpty());
        assertFalse(stack.isEmpty());
    }

    @Test
    void containsShouldWorkCorrect(){
        assertFalse(emptyStack.contains(1));
        assertFalse(stack.contains(101));
        assertTrue(stack.contains(50));
    }

    @Test
    void toArrayShouldWorkCorrect(){
        Object[] expected = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        assertArrayEquals(expected,stack.toArray());
        expected = new Object[0];
        assertArrayEquals(expected,emptyStack.toArray());
    }

    @Test
    void iterator_ShouldWorkCorrect(){
        Iterator<Integer> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(LAST_ELEMENT,iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(LAST_ELEMENT - 1,iterator.next());
        assertFalse(emptyStack.iterator().hasNext());
        assertThrows(IllegalStateException.class,
                ()-> emptyStack.iterator().next()) ;
        // Recover original stack
        init();
    }

    @Test
    void forEach_ShouldSumAllNumbers(){
        AtomicInteger sum = new AtomicInteger();
        stack.forEach(e-> {
            sum.set(sum.get() + e);
        });
        assertEquals(5050,sum.get());
    }
}
