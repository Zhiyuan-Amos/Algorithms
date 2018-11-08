import java.io.*;
import java.math.*;
import java.util.*;

class Main {
    
    private static class Interval implements Comparable<Interval> {
	   int low;
	   int high;

        public int compareTo(Interval other) {
            return this.low - other.low;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Interval[] V = new Interval[N];

    	for (int i = 0; i < N; i++) {
	       Interval I = new Interval();
           I.low = sc.nextInt();
           I.high = sc.nextInt();
           V[i] = I;
        }
        
        System.out.println(solve(N, V));
    }

    public static int solve(int N, Interval[] V) {
        Arrays.sort(V);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(V[0].high);

        for(int i = 1; i < V.length; i++) {
            if(V[i].low > pq.peek()) {
                pq.poll();
            } 
            pq.offer(V[i].high);
        }

        return pq.size();
    }
}
