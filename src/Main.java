import implementations.CustomArrayCollection;
import interfaces.iterable.collection.list.CustomList;

public class Main {

    public static void main(String[] args) {
        CustomList<Integer> list = new CustomArrayCollection<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1,4);

        System.out.println();
    }

}
