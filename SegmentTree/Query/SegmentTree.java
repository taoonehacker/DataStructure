package Query;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];//tree[treeIndex] = data[r];
            return;
        }

        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        int mid = l + (r - l) / 2;

        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);

        tree[treeIndex] = merger.merger(tree[leftChild], tree[rightChild]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }
        return data[index];
    }

    private int leftChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }

        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length)
            throw new IllegalArgumentException("the index is error");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在treeIndex为根的线段树[l,r]中，搜索queryL与queryR的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;

        //treeIndex的结点分为[l..mid]与[mid+1,r]
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E lefResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return merger.merger(lefResult, rightResult);

    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("the index is error");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;

        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
