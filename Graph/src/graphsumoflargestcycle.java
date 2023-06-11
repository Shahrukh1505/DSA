import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class graphsumoflargestcycle {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] edges = new int[n];
        for(int i = 0;i<n;i++){
            edges[i] = scn.nextInt();
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++){
            if(edges[i] != -1){
                graph.get(i).add(edges[i]);
                revGraph.get(edges[i]).add(i);
            }

        }

        //1. perform dfs and fill the nodes in post-order in the stack
        Stack<Integer> st = new Stack<>();
        boolean[]vis = new boolean[n];

        for(int i=0; i < n;i++) {
            if(vis[i] == false) {
                dfs(i,graph,vis,st);
            }
        }

        //3. perform dfs on this revGraph using order present in stack
        int scc = 0;
        vis = new boolean[n];
int nodeCount = 0;
int sumCycle = Integer.MIN_VALUE;
        while(st.size() > 0) {
            int src = st.pop();

            if(vis[src] == false) {
                scc++;
                int[] cnt = new int[1];
                int[] sum = new int[1];
                dfs(src,revGraph,vis, cnt, sum);
                if(cnt[0] > 1){
                    if(sum[0] > sumCycle){
                        sumCycle = sum[0];
                        nodeCount = cnt[0];
                    }
                }
            }
        }

        if(sumCycle == Integer.MIN_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(sumCycle);
        }




    }

    public static void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis,Stack<Integer>st) {
        vis[src] = true;

        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis,st);
            }
        }

        st.push(src);
    }

    public static void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]vis,int[] cnt, int[] sum) {
        vis[src] = true;
        sum[0] += src;
        cnt[0] += 1;
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfs(nbr,graph,vis,cnt, sum);
            }
        }

    }


}
