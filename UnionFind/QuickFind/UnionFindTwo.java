package QuickFind;

public class UnionFindTwo implements UF{

    public int[] parent;
    public UnionFindTwo(int size){
        parent = new int[size];
        for (int i=0;i<size;i++){
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if(p<0||p>=parent.length)
            throw new IllegalArgumentException("p is error");
        if(p!=parent[p])
            p = parent[p];
        return parent[p];
    }

    @Override
    public boolean isConnected(int p,int q) {
        return find(p)== find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot =find(q);

        if(qRoot==qRoot)
            return;
        parent[pRoot] = qRoot;
    }
}
