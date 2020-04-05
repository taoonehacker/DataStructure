package LinkedListStack;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedListStack(){
        data = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(data);
        return res.toString();
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        for(var i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
