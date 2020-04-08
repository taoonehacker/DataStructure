package Query;

public interface Set<E> {
    void add(E e);
    boolean isEmpty();
    void remove(E e);
    int getSize();
    boolean contains(E e);
}
