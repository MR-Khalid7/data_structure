
public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, head);
        head.setNext(tail);
        head.setPrev(tail);
        size = 0;
    }

    public boolean isEmpty() {
        return (head.getNext() == tail);
    }


    public int size() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");
        else if (size == 0) {
            Node<E> help = head;
            int size = 1;
            while (!help.equals(tail)) {
                size++;
                help = help.getNext();
            }
            this.size = size;
        }
        return this.size;
    }


    public boolean add(E element) {
        this.addBetween(element, tail.getPrev(), tail);
        return true;
    }


    public void add(int index, E element) {
        Node<E> oldNode = getNode(index);
        this.addBetween(element, oldNode.getPrev(), oldNode);
    }


    public void addFirst(E element) {
        this.addBetween(element, head, head.getNext());
    }

    public void addBetween(E element, Node<E> prev, Node<E> next) {
        if (prev == next)
            throw new IndexOutOfBoundsException("Previous and next elements are the same");
        Node<E> newNode = new Node<E>(element, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        this.size++;
    }


    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }


    public E remove(int index) {
        // Remove node from circular linked list
        Node<E> remove = getNode(index);
        Node<E> prevNode = remove.getPrev();
        Node<E> nextNode = remove.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        return remove.getElement();
    }


    public E first() {
        return firstNode().getElement();
    }


    public E last() {
        return lastNode().getElement();
    }

    private Node<E> firstNode() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");
        return head.getNext();
    }


    private Node<E> lastNode() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");
        return tail.getPrev();
    }


    public void rotate() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");
        head.getNext().setPrev(tail.getPrev());
        tail.getPrev().setNext(head.getNext());
        tail.setPrev(head.getNext());
        head.setNext(head.getNext().getNext());
        tail.getPrev().setNext(tail);
    }


    public E get(int index) {
        return this.getNode(index).getElement();
    }

    public int get(E value) {
        for (int i = 0; i < size(); i++)
            if (get(i).equals(value))
                return i;
        return -1;
    }


    public Node<E> getNode(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        if (isEmpty())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: 0");
        else if (index > (size() - 1))
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, this.size()));

        Node<E> helpPtr = this.head.getNext();
        for (int i = 0; i < index; i++)
            helpPtr = helpPtr.getNext();
        return helpPtr;
    }


    public class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }

}

