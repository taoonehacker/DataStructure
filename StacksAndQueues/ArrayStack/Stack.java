package ArrayStack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    //入栈
    void push(E e);
    //出栈
    E pop();
    //查询下栈顶的元素
    E peek();
}
