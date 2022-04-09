import java.util.*;




        // Definir como comparar dois elementos da classe Person
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"




    class FreqLetter implements Comparable<FreqLetter>{
    String letter;
    int pos;
    int freq;

    FreqLetter(String str, int pos){
        this.letter = str;
        this.pos = pos;
        this.freq++;
       
    }

    @Override
    public int compareTo(FreqLetter p) {
	if (freq < p.freq) return +1;
	if (freq > p.freq) return -1;
        if (pos < p.pos) return -1;
        else return +1;
    }
}

public class DAA009 {



    public static void countingLetters(String str){
        /*int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++){
            freq[((int)str.charAt(i)) - 65]++;
        }

        */
        int visited[] = new int[26];
        FreqLetter freqList[] = new FreqLetter[26];
        for(int i = 0; i < 26;i++){
            freqList[i] = new FreqLetter("", -1);
        }
        for(int i = 0; i < str.length(); i++){
            if(visited[str.charAt(i) - 'A'] == 0){
                visited[str.charAt(i) - 'A'] = 1;
                freqList[str.charAt(i) - 'A'] = new FreqLetter (Character.toString(str.charAt(i)), i);
            }
            else{
                freqList[str.charAt(i) - 'A'].freq++;
            }
        }
        Arrays.sort(freqList);
        for(int i = 0; i < freqList.length; i++){
            if(freqList[i] != null && freqList[i].freq != -1 && freqList[i].pos != -1) System.out.println(freqList[i].letter + " " + freqList[i].freq);
            

        }
       

    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        countingLetters(str);
        in.close();
    }
}
