import java.io.*;
import java.math.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] W = new int[N];
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        int solution = solve(N, W, V, C);
        System.out.println(solution);
    }

    public static int solve(int N, int[] W, int[] V, int C) {
        int[] ans = new int[C + 1];

        for(int i = 0; i < N; i++) {
        	for(int j = 1; j < C + 1; j++) {
        		int currentWt = W[i];
        		int currentVal = V[i];
        		if (j - currentWt >= 0 && ans[j - currentWt] + currentVal > ans[j]) {
        			ans[j] = ans[j - currentWt] + currentVal;
        		}
        	}
        }
        return ans[C];
    }
}