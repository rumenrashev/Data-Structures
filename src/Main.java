import implementations.ArrayStack;
import interfaces.Stack;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();
        for(int i = 1; i <= 100; i++){
            stack.push(i);
        }

        Object[] objects = stack.toArray();
        System.out.println();
    }
}
