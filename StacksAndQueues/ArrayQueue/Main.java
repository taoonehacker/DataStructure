package ArrayQueue;

public class Main {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }
}
