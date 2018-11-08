import java.io.*;
import java.math.*;
import java.util.*;

class DistanceBtwn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] R = new int[N + 1];
        int[] S = new int[N + 1];
        int[] T = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            R[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
           T[R[i]] = S[i]; // Sort S according to R's ordering and place in T
        }

        System.out.println(mergeSort(T, 1, N));
    }

    private static long mergeSort(int[] a, int lower, int upper) {
        long count = 0;
        if (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            count = mergeSort(a, lower, mid);
            count += mergeSort(a, mid + 1, upper);
            count += merge(a, lower, mid, upper);
        }
        return count;
    }
 
    private static long merge(int[] a, int lower, int mid, int upper) {
        long count = 0;
        int[] temp = new int[upper - lower + 1];

        int left = lower;
        int right = mid + 1;
        int it = 0;

        while (left <= mid && right <= upper) {
            if (a[left] <= a[right]) {
                temp[it++] = a[left++];
                count += (right - mid - 1);
            } else {
                temp[it++] = a[right++];
            }
        }

        while (left <= mid) {
            temp[it++] = a[left++];
            count += (right - mid - 1);
        }
        while (right <= upper) {
            temp[it++] = a[right++];
        }
        
        for(int k = 0; k < temp.length; k++) {
            a[lower + k] = temp[k];
        }

        return count;
    }
}