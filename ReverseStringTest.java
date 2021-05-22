package telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {
    String marina = "marina";
    String test1 = "aniram";
    ReverseString check = new ReverseString();
    @Test
    public void reverseTest(){
        assertEquals(test1,check.reverse(marina));
        assertEquals(test1.length(),check.reverse(marina).length());
    }



}