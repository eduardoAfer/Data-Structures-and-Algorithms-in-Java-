import java.util.Scanner;
import java.util.Arrays;

public class DAA014 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Encomenda[] encomendas = new Encomenda[N];
        for(int i  = 0; i < N; i++) 
            encomendas[i] = new Encomenda(in.nextDouble(), in.nextDouble(), i +1);
        Arrays.sort(encomendas);
        for(int i = 0; i < N; i++){
            if(i == N -1) System.out.print(encomendas[i].index);
            else System.out.print(encomendas[i].index + " ");
        } 
        System.out.println();
       //System.out.println(Arrays.toString(encomendas));
       //System.out.println(Arrays.deepToString(encomendas.index));


    }

    static class Encomenda implements Comparable<Encomenda>{
        double duracao;
        double multa;
        double racio;
        int index;

        Encomenda(double duracao, double multa, int index){
            this.duracao = duracao;
            this.multa = multa;
            this.index = index;
            racio = multa/duracao;
        }

        @Override
        public int compareTo(Encomenda o) {
            if(racio > o.racio) return -1;
            else if(racio < o.racio) return +1;
            else if(index > o.index) return +1;
            else if(index < o.index) return -1;
            return 0;
        }

    }
}
