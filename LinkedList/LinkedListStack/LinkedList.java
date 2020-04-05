package LinkedListStack;

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }

        var prev = dummyHead;
        for (var i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is error");
        }

        var cur = dummyHead.next;
        for (var i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public boolean contains(E e){
        var cur = dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index)
    {
        if(index<0 || index >=size){
            throw new IllegalArgumentException("the inddex is null");
        }

        var prev = dummyHead;
        for (var i=0;i<index;i++){
            prev = prev.next;
        }

        var delNode = prev.next;
        prev.next = delNode.next;
        delNode.next =null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public  E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        var prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if(prev!=null){
            var delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString(){
        var res = new StringBuilder();
        for(var cur = dummyHead.next;cur!=null;cur = cur.next){
            res.append(cur.e+"->");
        }
        res.append("Null");
        return res.toString();
    }

}
