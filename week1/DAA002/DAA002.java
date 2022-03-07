import java.util.Scanner;

public class DAA002 {

    public static int somaDigitos(int x) {

        int n = 0;

        while (x != 0) {
            n += x % 10;
            x /= 10;
        }

        return n;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int ctrl = in.nextInt();
        for (int i = 0; i < ctrl; i++) {
            int a = in.nextInt();
            a++;
            int b = in.nextInt();
            if (a == b)
                System.out.println(a);
            else {
                while (somaDigitos(a) != b) {
                    a++;
                }
                System.out.println(a);
            }
        }
    }

}
