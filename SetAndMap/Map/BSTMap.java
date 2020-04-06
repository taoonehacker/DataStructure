package Map;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else
            node.value = value;
        return node;
    }

    @Override
    public V get(K key) {
        var node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) > 0)
            return getNode(node.right, key);
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return node;
    }

    @Override
    public void set(K key, V newValue) {
        var node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist");
        node.value = newValue;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNoe = node.right;
                node.right = null;
                size--;
                return rightNoe;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);//getMaximum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }

    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

}
