import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java. util. Scanner;


public class binSearch{


    static class Pair implements Comparable<Pair> {
        int x;
        long p;

        Pair(int x, long p){
            this.x = x;
            this.p = p;
        }

        public int compareTo(Pair o){
            return(int) o.p - (int)this.p;
        }
    }



    public static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        FastScanner scn = new FastScanner();

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        while(k-- > 0){
            int el = scn.nextInt();

            int l = -1;
            int r = arr.length;

            while(r > l + 1){
                int mid = (l + r)/2;

                if(arr[mid] >= el){
                    r = mid;
                }
                else{
                    l = mid;
                }
            }

            System.out.println(r + 1);


        }










    }
    public static long countDivisibles(long A, long B, long M)
    {
        // Add 1 explicitly as A is divisible by M
        if (A % M == 0)
            return (B / M) - (A / M) + 1;

        // A is not divisible by M
        return (B / M) - (A / M);
    }

    public static long previousPerfectSquare(long N)
    {
        long prevN = (long)Math.floor(Math.sqrt(N));

        // If N is already a perfect square
        // decrease prevN by 1.
        if (prevN * prevN == N)
            prevN -= 1;

        return prevN * prevN;
    }

    public static long nextPerfectSquare(long N)
    {
        long nextN = (int)Math.floor(Math.sqrt(N)) + 1;

        return nextN * nextN;
    }


    public static double countSquares(long a, long b)
    {
        return (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }
    static final Random random=new Random();
    static final int mod=1_000_000_007;

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}



