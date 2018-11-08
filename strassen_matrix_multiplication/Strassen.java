import java.io.*;
import java.math.*;
import java.util.*;

class Strassen {
    final int LIMIT = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] C = strassen(N, A, B);

        long total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += C[i][j];
            }
        }

        System.out.println(total);
    }

    public static int[][] strassen(int N, int[][] A, int[][] B) {
        if(N <= 64){
            return standardAlgorithm(N, A, B);
        }
        else{
            int halfN = N / 2;

            int[][] a = new int[halfN][halfN];
            int[][] b = new int[halfN][halfN];
            int[][] c = new int[halfN][halfN];
            int[][] d = new int[halfN][halfN];

            int[][] e = new int[halfN][halfN];
            int[][] f = new int[halfN][halfN];
            int[][] g = new int[halfN][halfN];
            int[][] h = new int[halfN][halfN];

            int[][] resultTemp1 = new int[halfN][halfN];
            int[][] resultTemp2 = new int[halfN][halfN];

            // dividing the matrices in 4 sub-matrices:
            for (int i = 0; i < halfN; i++) {
                for (int j = 0; j < halfN; j++) {
                    a[i][j] = A[i][j];
                    b[i][j] = A[i][j + halfN];
                    c[i][j] = A[i + halfN][j];
                    d[i][j] = A[i + halfN][j + halfN];

                    e[i][j] = B[i][j]; 
                    f[i][j] = B[i][j + halfN];
                    g[i][j] = B[i + halfN][j];
                    h[i][j] = B[i + halfN][j + halfN];
                }
            }

            // Calculating p1 to p7:
            resultTemp1 = add(halfN, a, d);
            resultTemp2 = add(halfN, e, h);
            int[][] p1 = strassen(halfN, resultTemp1, resultTemp2);

            resultTemp1 = add(halfN, c, d); 
            int[][] p2 = strassen(halfN, resultTemp1, e);

            resultTemp2 = subtract(halfN, f, h); 
            int[][] p3 = strassen(halfN, a, resultTemp2);

            resultTemp2 = subtract(halfN, g, e); 
            int[][] p4 = strassen(halfN, d, resultTemp2);

            resultTemp1 = add(halfN, a, b); 
            int[][] p5 = strassen(halfN, resultTemp1, h);

            resultTemp1 = subtract(halfN, c, a); 
            resultTemp2 = add(halfN, e, f); 
            int[][] p6 = strassen(halfN, resultTemp1, resultTemp2);

            resultTemp1 = subtract(halfN, b, d); 
            resultTemp2 = add(halfN, g, h); 
            int[][] p7 = strassen(halfN, resultTemp1, resultTemp2);

            int[][] s = add(halfN, p3, p5); 
            int[][] t = add(halfN, p2, p4); 

            resultTemp1 = add(halfN, p1, p4); 
            resultTemp2 = add(halfN, resultTemp1, p7);
            int[][] r = subtract(halfN, resultTemp2, p5);

            resultTemp1 = add(halfN, p1, p3); 
            resultTemp2 = add(halfN, resultTemp1, p6); 
            int[][] u = subtract(halfN, resultTemp2, p2);

            int[][] C = new int[N][N];
            for (int i = 0; i < halfN; i++) {
                for (int j = 0; j < halfN; j++) {
                    C[i][j] = r[i][j];
                    C[i][j + halfN] = s[i][j];
                    C[i + halfN][j] = t[i][j];
                    C[i + halfN][j + halfN] = u[i][j];
                }
            }
            return C;           
        }
    }

    public static int[][] add(int N, int[][] A, int[][] B){
        int[][] C = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtract(int N, int[][] A, int[][] B){
        int[][] C = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static int[][] standardAlgorithm(int N, int[][] A, int[][] B){
        int[][] C = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return C;
    }
}