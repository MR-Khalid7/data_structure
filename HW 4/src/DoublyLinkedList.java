public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    }

    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);

    }


    public boolean isEmpty() {
        return size()==0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement(); // first element is beyond header
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement(); // last element is before trailer
    }


    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);

    }




    public  int size() {
        int count = 0;
        Node helper = header;
        while (helper != null) {
            count++;
            helper = helper.next;
        }
        return count;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DoublyLinkedList)) {
            return false;
        }
        DoublyLinkedList otherList = (DoublyLinkedList) other;
        if (size() != otherList.size()) {
            return false;
        }
        Node helper1 = header;
        Node helper2 = otherList.header;
        while (helper1 != null) {
            if (!helper1.element.equals(helper2.element)) {
                return false;
            }
            helper1 = helper1.next;
            helper2 = helper2.next;
        }
        return true;
    }

    public DoublyLinkedList clone() {
        DoublyLinkedList clone = new DoublyLinkedList();
        Node helper = header;
        while (helper != null) {
            clone.addLast(helper.element);
            helper = helper.next;

        }
        return clone;
    }


}
