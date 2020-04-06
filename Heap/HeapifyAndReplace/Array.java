package HeapifyAndReplace;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }
        for (var i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

        if (size == data.length) {
            resize(2 * data.length);
        }
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (var i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }

        return false;
    }

    public int find(E e) {
        for (var i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is error");
        }
        var result = data[index];
        for (var i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        var index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    private void resize(int newCapacity) {
        var newData = (E[]) new Object[newCapacity];
        for (var i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j) {
        if ((i < 0 || i >= size) || (j < 0 || j >= size))
            throw new IllegalArgumentException("the index is error");
        E t = data[i];
        data[j] = data[i];
        data[i]=t;
    }

    @Override
    public String toString() {
        var res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append("[");
        for (var i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}

