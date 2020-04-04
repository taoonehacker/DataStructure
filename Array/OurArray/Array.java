package OurArray;

public class Array {

    //数组个数
    private int size;
    //数组
    private int[] data;

    //构造函数 capacity 数组容量
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参构造函数
    public Array() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("the data is full");
        }
        //插入元素可以在size的索引上插入
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index is error");
        }
        //1 2 3 4 5
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is error");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("the index is error");
        }
        data[index] = e;
    }

    //是否包含元素
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //查找元素在数组中的索引位置
    public int Find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("the index is error");
        // 1 2 3 4 5
        //找到要移动的元素
        var result = Find(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return result;
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int removeFirst() {
        return remove(0);
    }

    public void removeElement(int e) {
        var index = Find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append("[");
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
