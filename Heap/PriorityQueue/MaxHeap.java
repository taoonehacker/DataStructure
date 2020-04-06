package PriorityQueue;

import HeapifyAndReplace.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    //Heapify
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("the index is error");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //取出最大元素
    public E extractMax() {
        var ret = findMax();

        //1.交换根元素与最后元素
        //2.删除最后元素
        //2.与左右两个孩子之间的最大的孩子做比较，比最大的孩子还要小，交换，递归

        data.swap(0, getSize() - 1);
        data.removeLast();

        siftDown(0);


        return ret;
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("the heap is empty");
        return data.get(0);
    }

    private void siftDown(int k) {
        //循环条件：如果有子节点 即左孩子索引不越界
        while (leftChild(k) < getSize()) {
            int j = leftChild(k);
            //判断是否有右孩子 并且右孩子比做孩子大
            if (j + 1 < getSize() && data.get(j).compareTo(data.get(j + 1)) < 0)
                j++;
            //此时data.get(j)就是左右孩子中的最大值
            //交换k与j元素
            data.swap(k, j);
            //把j赋值给k，继续循环
            k = j;
        }
    }


    public E replace(E e){
        var ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
