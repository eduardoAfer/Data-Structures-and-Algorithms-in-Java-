import java.util.*;

class DAA010 {

    public static void main(String[] arga) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] S = new int[N];

        for (int i = 0; i < N; i++)
            S[i] = in.nextInt();

        int Q = in.nextInt();
        int[] P = new int[Q];

        for (int i = 0; i < Q; i++)
            P[i] = in.nextInt();

        int[] somas = new int[(N * N - N) / 2];
        int aux = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                somas[aux] = S[i] + S[j];
                aux++;
            }
        }
        Arrays.sort(somas);
        for (int i = 0; i < Q; i++) {
            System.out.println(bsearch(somas, 0, somas.length - 2, P[i]));
        }
        in.close();
    }

    public static int bsearch(int[] v, int low, int high, int key) {
        int middle = 0;
        while (low <= high) {
            middle = low + ((high - low) / 2);
            if (key <= v[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        if (high == -1) return v[0];

        if (Math.abs(v[low] - key) < Math.abs(key - v[high]))
            return v[low];
        else if (Math.abs(v[low] - key) == Math.abs(key - v[high])) {
            System.out.print(v[high] + " ");
            return v[low];
        }
        return v[high];
    }
} 