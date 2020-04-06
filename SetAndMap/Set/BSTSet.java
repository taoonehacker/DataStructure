package Set;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> data;

    public BSTSet(){
        data = new BST<E>();
    }

    @Override
    public void add(E e) {
        data.add(e);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void remove(E e) {
        data.remove(e);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }
}
