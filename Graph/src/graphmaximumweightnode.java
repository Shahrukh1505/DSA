import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class graphmaximumweightnode {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] edges = new int[n];
        for(int i = 0;i<n;i++){
            edges[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int node = -1;
        for (int i = 0; i < edges.length; i++) {
            if(edges[i] != -1){
                int nf = hm.getOrDefault(edges[i], 0) + i;
                hm.put(edges[i], nf);
                if(nf >  max){
                    max = nf;
                    node = edges[i];
                }

            }

        }

        System.out.println(node);
    }
}
