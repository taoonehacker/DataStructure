package QuickUnion;

public class UnionFindFive implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFindFive(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is error");
        if (p != parent[p])
        {
            parent[p]= parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot== qRoot){
            return;
        }

        if(rank[pRoot]< rank[qRoot])
        {
            parent[pRoot] = qRoot;
        }
        else if(rank[pRoot]>rank[qRoot])
        {
            parent[qRoot] = pRoot;
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot] +=1;
        }
    }
}
