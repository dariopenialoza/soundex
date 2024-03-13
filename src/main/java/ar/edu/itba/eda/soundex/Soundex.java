package ar.edu.itba.eda.soundex;
public class Soundex {

    public static String representation(String s){
        s = s.toUpperCase();
        char[] IN = s.toCharArray();
        char[] OUT = {'0','0','0','0'};
        OUT[0] = IN[0];
        int count = 1;
        int current, last = getMapping(IN[0]);
        for(int i=1; i < IN.length && count < 4; i++){
            char iter=IN[i];
            current = getMapping(iter);
            if(current != 0 && current !=last)
                OUT[count++] = toChar(current);
            last = current;
        }
        return new String(OUT);
    }
    public static int getMapping(char c){

        c = Character.toUpperCase(c);

        if (c == ' ' || c == '\t' || c== '\n' || c== '\r')

            return 0;

        int [] code= {0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5, 5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2 };

        return code[(c - 'A')];

    }

    public static char toChar(int n) {
        return  (char) (n + '0');
    }
}
