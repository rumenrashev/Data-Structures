package benchmark;

import implementations.ArrayStack;
import interfaces.Stack;
import org.junit.jupiter.api.Test;

public class ArrayStackBenchmark {

    @Test
    void timeToPushAndPopOneMillionElements(){
        long start = System.currentTimeMillis();
        Stack<Integer> arrayStack = new ArrayStack<>();
        for(int i = 0; i < 1_000_000; i++){
            arrayStack.push(i);
        }
        while (!arrayStack.isEmpty()){
            arrayStack.pop();
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("ArrayStack:");
        System.out.printf("Push and pop one million elements for %d milliseconds%n",diff);
    }
}
