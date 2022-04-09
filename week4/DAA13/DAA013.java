import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DAA013 {

    //public static Segments[] removSegments()

    public static int countSegments(Segments[] arr, int N, int M){
        int finalLine = arr[0].f;
        ArrayList<Segments> segmentsList = new ArrayList<>();
        segmentsList.add(arr[0]);
        Segments temp = new Segments(0,0);
        for(int i = 1; i < N && finalLine < M; i++){
            int j = i;
            while(arr[j].s <= finalLine){
                if(finalLine >= M) break; 
                if(temp.f < arr[j].f) temp = arr[j];
                j++;
                if(j == N) break;
            }
            
            finalLine = temp.f;

          //  if(arr[i].s <= finalLine && arr[i].f > finalLine && finalLine <= M){
            segmentsList.add(temp);
             //   finalLine = arr[i].f;
           // }
        }
        //removeDuplicates(segmentsList);
        //for(Segments i : segmentsList)
       // System.out.println(i.s + " " + i.f);
        return segmentsList.size();
    }


    public static void main(String[] arga) {
        Scanner in = new Scanner(System.in);

        final int M = in.nextInt();
        final int N = in.nextInt();
        Segments[] Segments = new Segments[N];

        for (int i = 0; i < N; i++)
            Segments[i] = new Segments(in.nextInt(), in.nextInt());
        
        in.close();
        Arrays.sort(Segments);
        //for(Segments i : arrSegments )
        //System.out.println(i.s + " " + i.f);

       System.out.println(countSegments(Segments, N, M));
    

    }
}

class Segments implements Comparable<Segments> {

    int s;
    int f;

    Segments(int s, int f) {
        this.s = s;
        this.f = f;
    }

    @Override
    public int compareTo(Segments p) {
        if (s > p.s)
            return +1;
        else if (s < p.s)
            return -1;
        else if (f > p.f)
            return -1;
        else if (f < p.f)
            return +1;
        return 0;
    }
}