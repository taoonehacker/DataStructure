package Remove;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else
            return contains(node.left, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.right);
        System.out.println(node.e);
        postOrder(node.left);
    }

    public void levelOrder() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);

            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public E minimum(){
        if(isEmpty())
            throw new IllegalArgumentException("bst is empty");
        var minNode = minimum(root);
        return minNode.e;
    }

    private Node minimum(Node node){
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(isEmpty())
            throw new IllegalArgumentException("bst is empty");
        var maxNode = maximum(root);
        return maxNode.e;
    }

    private Node maximum(Node node){
        if(node.right==null)
            return node;
        return maximum(node.right);
    }

    public E removeMin(){
        var res = minimum();
        root = removeMin(root);
        return res;
    }

    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public  E removeMax()
    {
        var res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    //删除掉以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后的新的二分搜索树的根
    private Node remove(Node node,E e){
        //递归到底如果node==null 返回null
        if(node == null)
            return null;

        //如果节点比当前根节点小 去左子树删除
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }
        //如果节点比当前跟节点大 去右子树删除
        else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }
        else
        {
            //如果节点等于当前节点 那么当前节点就是要删除的节点
            //如果当前节点的左子树为空
            //返回当前节点的右子树
            if(node.left==null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //如果当前节点的右子树为空
            //返回当前节点的左子树
            if(node.right ==null)
            {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //如果当前节点的左右子树都不为空
            //1.找到右子树中最小的节点，作为当前节点的后继节点
            //2.替换当前节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
}


