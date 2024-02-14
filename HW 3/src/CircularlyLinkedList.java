import org.w3c.dom.ls.LSOutput;

public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList() {
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void mySize(){
        if (isEmpty())
            System.out.println("There are no elements");
        else {
            int num=1;
            Node<E> help=tail;
            while(help.next != tail){
                num++;
                help=help.next;

            }
            System.out.println(num);}
    }

    public boolean equals(Object model) {
        if (model == this) {
            return true; // Same object
        }

        if (!(model instanceof CircularlyLinkedList<?>)) {
            return false; // Different class
        }

        @SuppressWarnings("unchecked")
        CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) model;

        if (this.size() != other.size()) {
            return false; // Different sizes
        }

        // Compare elements, starting from the front
        Node<E> help1 = this.tail;
        Node<E> help2 = other.tail;

        do {
            if (!help1.element.equals(help2.element)) {
                return false; // Elements differ
            }
            help1 = help1.next;
            help2 = help2.next;
        } while (help1 != this.tail);

        return true; // All elements matched
    }

    public void addFirst(E element) {
        if (size == 0) {
            tail = new Node<E>(element, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<E>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E element){
        addFirst(element);
        tail = tail.getNext();
    }
    public E removeFirst(){
        if (isEmpty())return null;
        Node<E> deleted = tail.getNext();
        if(deleted == tail)
            tail = null;

        else{
            tail.setNext(deleted.getNext());
        }
        size--;
        return deleted.getElement();
    }
    public void rotate(){
        if(tail != null)
            tail = tail.getNext();

    }
    public void testing() {
        // إنشاء قائمة متصلة دائرية
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        // إضافة عناصر إلى القائمة
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(9);

        // طباعة العناصر في القائمة

        System.out.print("قائمة العناصر: ");
        printList((CircularlyLinkedList<E>) list);


        //  System.out.print("قائمة العناصر: ");
//            Node<Integer> current = list.tail.getNext();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(current.getElement() + " ");
//                current = current.getNext();
//            }
//            System.out.println();

        // طباعة حجم القائمة
        System.out.println("حجم القائمة: " + list.size());

        // طباعة أول وآخر عنصر في القائمة
        System.out.println("العنصر الأول: " + list.first());
        System.out.println("العنصر الأخير: " + list.last());

        // إزالة العنصر الأول من القائمة
        Integer removed = list.removeFirst();
        System.out.println("تمت إزالة العنصر: " + removed);

        // طباعة العناصر بعد إزالة العنصر الأول
        System.out.print("قائمة العناصر بعد الإزالة: ");
        printList((CircularlyLinkedList<E>) list);


//            current = list.tail.getNext();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(current.getElement() + " ");
//                current = current.getNext();
//            }
//            System.out.println();

        // دوران القائمة
        list.rotate();
        // طباعة العناصر في القائمة
        System.out.print("قائمة العناصر بعد الدوران: ");
        printList((CircularlyLinkedList<E>) list);

        // طباعة العناصر بعد الدوران
//            System.out.print("قائمة العناصر بعد الدوران: ");
//            current = list.tail.getNext();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(current.getElement() + " ");
//                current = current.getNext();
//            }
//            System.out.println();


    }


    // for print element
    public void printList(CircularlyLinkedList<E> list) {
        Node<E> current = list.tail.getNext();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    // other way to print element
    public void printElements() {
        if (isEmpty()) {
            System.out.println("القائمة فارغة.");
            return;
        }

        Node<E> current = tail.getNext();
        System.out.print("العناصر في القائمة: ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
        return;
    }


    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }


        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}