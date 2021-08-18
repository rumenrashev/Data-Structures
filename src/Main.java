import implementations.iterable.collections.linked.DoublyLinkedList;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);


        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.removeLast());
    }
}
