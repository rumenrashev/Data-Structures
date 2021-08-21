import implementations.iterable.collections.linked.DoublyLinkedList;
import interfaces.iterable.collections.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new DoublyLinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);

        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());

        System.out.println();
    }
}
