package QuickFind;

import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        int size = 100000;
        int m = 100000;

        UnionFindOne uf1 = new UnionFindOne(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionFindTwo uf2 = new UnionFindTwo(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");
    }
}
