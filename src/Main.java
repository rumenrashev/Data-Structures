import implementations.ArrayStack;
import implementations.LinkedStack;
import interfaces.Stack;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Stack<Integer> arrayStack = new LinkedStack<>();

        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            arrayStack.push(i);
        }

        while (arrayStack.isEmpty()) {
            arrayStack.pop();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
