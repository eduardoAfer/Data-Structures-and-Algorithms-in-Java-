import java.util.Scanner;
import java.lang.Math; 


class DAA006 {

    public static float distance(float x1, float y1, float x2, float y2) {
      float distance = (float)Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
      return distance;
    }
  
  
    public static float intersection(float x1, float x2, float y1, float y2, int cx, int cy, int r) {
  
      
      if ( distance(x1,y1,cx,cy) >= r &&   
           distance(x1,y2,cx,cy) >= r &&   
           distance(x2,y1,cx,cy) >= r &&    
           distance(x2,y2,cx,cy) >= r &&   
           (x1>=cx+r || x2<=cx-r || y1>=cy+r || y2<=cy-r) ) return 0;
  
     
      if ( distance(x1,y1,cx,cy) <= r &&
           distance(x1,y2,cx,cy) <= r &&
           distance(x2,y1,cx,cy) <= r &&
           distance(x2,y2,cx,cy) <= r ) return ((x2-x1)*(y2-y1));
  
      
      if ( cx-r>=x1 && cx+r<=x2 && cy-r>=y1 && cy+r<=y2 ) return (float)(r*r*Math.PI);
  
      float area = 0;
      float half = (x2-x1)/2;
      if ( (x2-x1)*(y2-y1) >= 0.00001 ) {
        area += intersection(x1, x2-half, y1+half, y2, cx, cy, r); 
        area += intersection(x1+half, x2, y1+half, y2, cx, cy, r); 
        area += intersection(x1, x2-half, y1, y2-half, cx, cy, r);  
        area += intersection(x1+half, x2, y1, y2-half, cx, cy, r);  
      }
  
      return area;
    }
  
  
    public static void main (String[] args) {
  
      FastScanner in = new FastScanner(System.in);
  
      int n = in.nextInt();   
  
      for (int i=0 ; i<n ; i++) {
        int qx = in.nextInt();    
        int qy = in.nextInt();    
        int ql = in.nextInt();    
  
        int cx = in.nextInt();    
        int cy = in.nextInt();   
        int cr = in.nextInt();    
  
        FastPrint.out.println(intersection(qx, qx+ql, qy, qy+ql, cx, cy, cr));
      }
      FastPrint.out.close();
  
    }
  
  }
