import implementations.ArrayStack;
import interfaces.Stack;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Stack<Integer>stack = new ArrayStack<>();
        for (int i = 1; i <= 100; i++) {
            stack.push(i);
        }

        AtomicInteger sum = new AtomicInteger();
        stack.forEach(e-> {
            sum.set(sum.get() + e);
        });

        System.out.println(sum.get());

    }
}
