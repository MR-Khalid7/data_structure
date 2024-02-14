public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> x=new DoublyLinkedList<>();

        x.addFirst(2);
        x.add(30);
        System.out.println(x.get(1));
        x.remove(0);

    }
}