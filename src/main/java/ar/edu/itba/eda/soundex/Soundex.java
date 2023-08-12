package ar.edu.itba.eda.soundex;
public class Soundex {

    public static String representation(String s){
        s = s.toUpperCase();
        char[] IN = s.toCharArray();
        char[] OUT = {'0','0','0','0'};
        OUT[0] = IN[0];
        int count = 1;
        int current, last = getCode(IN[0]);
        for(int i=1; i < IN.length && count < 4; i++){
            char iter=IN[i];
            current = getCode(iter);
            if(current != 0 && current !=last)
                OUT[count++] = toChar(current);
            last = current;
        }
        return new String(OUT);
    }
    public static int getCode(char c){
        c = Character.toUpperCase(c);
        String [] code = {"B,F,P,V","C,G,J,K,Q,S,X,Z","D,T","L","M,N","R"};
        for( int i = 0; i < code.length; i++){
            if( code[i].indexOf(c) >= 0)
                return i+1;
        }
        return 0;
    }

    public static char toChar(int n) {
        return  (char) (n + '0');
    }
}
