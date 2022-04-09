import java.util.*;

public class DAA011 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int[] dist = new int[N];
        int max = 0;

        for (int i = 0; i < N; ++i) {
            dist[i] = stdin.nextInt();
            max += dist[i];
        }
        int p = stdin.nextInt();
        for (int i = 0; i < p; i++) 
            System.out.println(bsearch(dist, 0, max, stdin.nextInt()));
        

        stdin.close();
    }

    public static int bsearch(int[] D, int l, int r, int k) {
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (cond(D, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static boolean cond(int[] dist, int mid, int k) {
        int acc = 0;
        int partitions = 0;
        for (int i : dist) { 
            acc += i; 
            if (acc > mid) { 
                acc = i; 
                if (i > mid)
                    return false;
                if (++partitions > k) { 
                    return false; 
                }
            }
        }
        return partitions < k;
    }
}