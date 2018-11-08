import java.io.*;
import java.math.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] V = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            V[i] = sc.nextInt();

        System.out.println(solve(N, V, C));
    }

    public static String solve(int N, int[] V, int C) {
        if (C == 0)
            return "YES";

        // Initialisation
        int arr[][] = new int[N + 1][C + 1];
        for (int i = 0; i < N + 1; i++)
        	arr[i][0] = 0;
        for (int i = 0; i < C + 1; i++)
        	arr[0][i] = 0;

        for (int i = 1; i < N + 1; i++) {
        	for (int j = 1; j < C + 1; j++) {
        		if (j == V[i] || (j - V[i] >= 0 && arr[i - 1][j - V[i]] == 1))
        			arr[i][j] = 1;
        		else
        			arr[i][j] = 0;
        	}
        }

        for (int i = 1; i < N+1; i++) {
        	if (arr[i][C] == 1)
        		return "YES";
        }
        return "NO";
    }
}