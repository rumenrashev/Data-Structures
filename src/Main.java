import implementations.ArrayStack;
import implementations.LinkedStack;
import interfaces.Stack;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Stack<Integer> arrayStack = new LinkedStack<>();

        for (int i = 0; i <= 100_000_000; i++) {
            arrayStack.push(i);
        }

        while (arrayStack.isEmpty()) {
            arrayStack.pop();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
