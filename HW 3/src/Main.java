
public class Main {
    public static void main(String[] args) {

        CircularlyLinkedList<Integer> amr2 = new CircularlyLinkedList<Integer>();
        CircularlyLinkedList<Integer> amr = new CircularlyLinkedList<Integer>();
        amr.mySize();
        amr.addLast(12);
        amr.mySize();
        amr2.addFirst(12);
        System.out.println(amr.equals(amr2));

    }
}