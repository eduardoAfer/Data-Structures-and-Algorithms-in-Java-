


import java.util.Scanner;
import java.lang.Character;

public class DAA003 {



    //==================================

    // falta tratar os numeros sendo os primeiros a mudar

    //=================================


    public static int tonumeric(String p){


        if(checkGen(p)      == 1){
            // 0 -> 48 
            // A -> 65
            //XX-NN-NN (1ª geração), NN-NN-XX (2ª geração),
             //sNN-XX-NN (3ª geração) ou XX-NN-XX (4ª geração
            
            int d0 = ((int) p.charAt(6)) - 65;
            d0 *= 230000;
            int d1 = ((int) p.charAt(7)) - 65;
            d1 *= 23000;
            int d2 = ((int) p.charAt(3)) - 48;
            d2 *= 1000;
            int d3 = ((int) p.charAt(4)) - 48;
            d3 *= 100;
            int d4 = ((int) p.charAt(6)) - 48;
            d4 *= 10;
            int d5 = ((int) p.charAt(7)) - 48;
            d5 *= 1;
          
            return  (d0 + d1 + d2 + d3 + d4 + d5);
        }
       

        if(checkGen(p)      == 2){

            
            int d0 = ((int) p.charAt(6)) - 65;
            d0 *= 230000;
            int d1 = ((int) p.charAt(7)) - 65;
            d1 *= 23000;
            int d2 = ((int) p.charAt(0)) - 48;
            d2 *= 1000;
            int d3 = ((int) p.charAt(1)) - 48;
            d3 *= 100;
            int d4 = ((int) p.charAt(3)) - 48;
            d4 *= 10;
            int d5 = ((int) p.charAt(4)) - 48;
            d5 *= 1;
          
            return  (d0 + d1 + d2 + d3 + d4 + d5 + 5290000);

           

        }  
        else if(checkGen(p) == 3){
             

            int d0 = ((int) p.charAt(3)) - 65;
            d0 *= 230000;
            int d1 = ((int) p.charAt(4)) - 65;
            d1 *= 23000;
            int d2 = ((int) p.charAt(0)) - 48;
            d2 *= 1000;
            int d3 = ((int) p.charAt(1)) - 48;
            d3 *= 100;
            int d4 = ((int) p.charAt(6)) - 48;
            d4 *= 10;
            int d5 = ((int) p.charAt(7)) - 48;
            d5 *= 1;
          
            return  (d0 + d1 + d2 + d3 + d4 + d5 + 10580000);
        }  
        else if(checkGen(p) == 4){
           

            int d0 = ((int) p.charAt(0)) - 65;
            d0 *= 230000;
            int d1 = ((int) p.charAt(1)) - 65;
            d1 *= 23000;
            int d2 = ((int) p.charAt(6)) - 65;
            d2 *= 2300;
            int d3 = ((int) p.charAt(7)) - 65;
            d3 *= 230;
            int d4 = ((int) p.charAt(3)) - 48;
            d4 *= 10;
            int d5 = ((int) p.charAt(4)) - 48;
            d5 *= 1;
          
            return  (d0 + d1 + d2 + d3 + d4 + d5 + 15870000);

        } 
        else return 0; 
    }


    public static int checkGen(String P){
        int n = 0;
        if(Character.isLetter(P.charAt(0)) && !Character.isLetter(P.charAt(3)) &&
            !Character.isLetter(P.charAt(6)) )
            n = 1;
        else if(!Character.isLetter(P.charAt(0)) && !Character.isLetter(P.charAt(3)) &&
            Character.isLetter(P.charAt(6)) )        
            n = 2;
        else if(!Character.isLetter(P.charAt(0)) && Character.isLetter(P.charAt(3)) &&
            !Character.isLetter(P.charAt(6)) )        
            n = 3;
        else if(Character.isLetter(P.charAt(0)) && !Character.isLetter(P.charAt(3)) &&
            Character.isLetter(P.charAt(6)) )        
            n = 4;

        return n;
    }

    public static int distancia(String p1, String p2){
        int p1_aux = tonumeric(p1);
        int p2_aux = tonumeric(p2);

        return Math.abs(p1_aux - p2_aux);

    }
        public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            
            for(int i = 0; i < T; i++){
                String P1 = in.next();
                String P2 = in.next();
                System.out.println(distancia(P1, P2));
            }
            in.close();
    }
}
