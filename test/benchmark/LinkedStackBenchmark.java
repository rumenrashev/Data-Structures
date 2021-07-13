package benchmark;

import implementations.ArrayStack;
import implementations.LinkedStack;
import interfaces.Stack;
import org.junit.jupiter.api.Test;

public class LinkedStackBenchmark {
    
    @Test
    void timeToPushAndPopOneMillionElements(){
        long start = System.currentTimeMillis();
        Stack<Integer> linkedStack = new LinkedStack<>();
        for(int i = 0; i < 1_000_000; i++){
            linkedStack.push(i);
        }
        while (!linkedStack.isEmpty()){
            linkedStack.pop();
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Linked stack:");
        System.out.printf("Push and pop one million elements for %d milliseconds%n",diff);
    }
}
