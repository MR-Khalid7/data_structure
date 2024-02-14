

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> a=new DoublyLinkedList<>();
        a.addFirst(4);
        a.addFirst(3);
        a.addFirst(1);
        DoublyLinkedList a2= a.clone();
        System.out.println(a.findSize());
        System.out.println(a2.findSize());
        System.out.println(a2.equals(a));


    }
}