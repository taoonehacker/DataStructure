package Set;

import java.util.ArrayList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    private LinkedList<E> data;

    public LinkedListSet(){
        data = new LinkedList<E>();
    }

    @Override
    public void add(E e) {
        if(!data.contains(e))
            data.addLast(e);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void remove(E e) {
        data.removeElement(e);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean contains(E e) {
        return data.contains(e);
    }

    public static void main(String[] args){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
