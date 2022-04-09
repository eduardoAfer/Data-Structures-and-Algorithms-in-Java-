package DAA005;
import java.util.*;
public class DAA005 {

   public static void energySet(int set[], int a, int b){ 
        if( a == 1) FastPrint.out.println(set[b -1]);
        else FastPrint.out.println(set[b -1 ] - set[a - 2]);
    }

    public static void main(String args[]){
        FastScanner in = new FastScanner(System.in);

        int ctrl = in.nextInt();
        int collection[] = new int[ctrl];
        collection[0] = 0; 

        for(int i = 0; i < ctrl; i++){
            if(i == 0) collection[i] = in.nextInt();
            else collection[i] = collection[i -1] + in.nextInt();

        }
        
        ctrl = in.nextInt();
        for(int i = 0; i < ctrl; i++){
           energySet(collection, in.nextInt(), in.nextInt());
        }
        FastPrint.out.close();
    }
    
    
}
