import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class graphnearestmeetingcell {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] edges = new int[n];
        for(int i = 0;i<n;i++){
            edges[i] = scn.nextInt();
        }
        int a = scn.nextInt();
        int b = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++){
            if(edges[i] != -1){
                graph.get(i).add(edges[i]);
            }

        }
        int[] arr = new int[n];
        int[] brr = new int[n];

        bfs(graph, arr, a);
        bfs(graph, brr, b);

        int node = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(arr[i] != 0 && brr[i] != 0){
                if(arr[i] + brr[i] < min){
                    min = arr[i] + brr[i];
                    node = i;
                }
            }

        }

        System.out.println(node);

    }
    static class Pair{
        int u;
        int dist;

        Pair(int u, int dist){
            this.u = u;
            this.dist = dist;
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int[] arr, int a) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(a, 0));

        while(q.size()>0){
            Pair rem = q.remove();

            if(vis[rem.u] == true){
                continue;
            }

            vis[rem.u] = true;

            for(Integer nbr : graph.get(rem.u)){
                if(vis[nbr] == false){
                    arr[nbr] = rem.dist + 1;
                    q.add(new Pair(nbr, rem.dist + 1));
                }
            }
        }

    }
}
