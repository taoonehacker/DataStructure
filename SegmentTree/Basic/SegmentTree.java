package Basic;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }
        return data[index];
    }

    public int leftChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }

        return 2 * index + 1;
    }

    public int rightChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }

        return 2 * index + 2;
    }



}
