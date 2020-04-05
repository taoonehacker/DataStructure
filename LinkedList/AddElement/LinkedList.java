package AddElement;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void AddFirst(E e) {
//        var node =new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }

        if (index == 0) {
            AddFirst(e);
        } else {
            var prev = head;
            for (var i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

}
