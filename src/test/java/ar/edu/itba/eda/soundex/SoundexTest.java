package ar.edu.itba.eda.soundex;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class SoundexTest {
    @Test
    void soundexRepresentationLUxuRY() {
        String expected = "L260";
        String result = Soundex.representation("LUxuRy");
        assertEquals(expected,result);
    }

    @Test
    void soundexRepresentationSZLLOYDTIRUL() {
        assertEquals("S436",Soundex.representation("SZLLOYDTIRUL"));
    }

    @Test
    void representationTest() {
        String[] strings = {"LUxuRY","LUxuRY  YYYAAAEE","SZLLOYDTIRUL"};
        Assertions.assertAll( ()-> assertEquals("L260", Soundex.representation(strings[0])),
                            ()-> assertEquals("L260",Soundex.representation(strings[1])),
                            ()-> assertEquals("S436",Soundex.representation(strings[2])) );
    }

    @Test
    void getCodeTest() {
        char[] chars = {'a','B','x','D','L','M','R'};

        Assertions.assertAll(()->assertEquals(0,Soundex.getCode(chars[0])),
                            ()->assertEquals(1,Soundex.getCode(chars[1])),
                            ()->assertEquals(2,Soundex.getCode(chars[2])),
                            ()->assertEquals(3,Soundex.getCode(chars[3])),
                            ()->assertEquals(4,Soundex.getCode(chars[4])),
                            ()->assertEquals(5,Soundex.getCode(chars[5])),
                            ()->assertEquals(6,Soundex.getCode(chars[6])));
    }

    private static Object[][] values(){
        return new Object[][]{{'0',0},{'1',1},{'2',2},{'3',3},{'4',4},{'5',5},{'6',6}};
    }

    @ParameterizedTest
    @MethodSource("values")
    void toCharTestValues(char e, int v){
        assertEquals(e,Soundex.toChar(v));
    }

    @Test
    void toCharTestArray() {
        int[] ints = {0,1,2,3,4,5,6};
        Assertions.assertAll(()->assertEquals('0',Soundex.toChar(0)),
                            ()->assertEquals('1',Soundex.toChar(1)),
                            ()->assertEquals('2',Soundex.toChar(2)),
                            ()->assertEquals('3',Soundex.toChar(3)),
                            ()->assertEquals('4',Soundex.toChar(4)),
                            ()->assertEquals('5',Soundex.toChar(5)),
                            ()->assertEquals('6',Soundex.toChar(6)));
    }
}