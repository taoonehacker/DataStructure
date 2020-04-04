package Basic;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = i;
        }
        int[] sources = new int[]{100,98,55,69};

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        for (int source:sources){
            System.out.println(source);
        }
    }
}
