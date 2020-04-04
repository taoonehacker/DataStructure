package LoopQueue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue()
    {
        this(10);
    }

    @Override
    public int getSize() {
        return tail > front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue is empty");
        var res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        var newData = (E[]) new Object[newCapacity + 1];
        for (var i = 0; i < getSize(); i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize();
    }

    @Override
    public String toString(){
        var res = new StringBuilder();
        res.append("Queue:");
        res.append("front[");
        for(var i = front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail){
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
