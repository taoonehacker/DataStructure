package LoopQueue;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    //入队
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    //出队
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    //查询队首元素
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        var res = new StringBuilder();
        res.append("Queue:");
        res.append("[");
        for (var i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
