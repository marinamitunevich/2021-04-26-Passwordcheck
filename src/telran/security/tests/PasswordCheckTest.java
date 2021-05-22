package telran.security.tests;

import org.hamcrest.Condition;
import org.junit.Test;
import telran.security.IllegalPasswordException;
import telran.security.PasswordCheck;

import java.util.*;

import static org.junit.Assert.*;

public class PasswordCheckTest {
    PasswordCheck checkPassword = new PasswordCheck();

    @Test
    public void rightPasswordTest(){
        String password = "?/lll8JJJll";

        boolean flag = false;
        try {
            checkPassword.check(password);
            flag = true;
        } catch (IllegalPasswordException e) {
            for(int i =0; i<e.getMessages().length;i++)
            {
                System.out.println(e.getMessages()[i]);
            }
            flag = false;
        }catch (IllegalArgumentException e){
            e.getMessage();
        }

        assertTrue(flag);

    }

    @Test
    public void wrongLengthTest(){
        String password = "kJ!8";
        boolean flag =false;
        try {
            checkPassword.check(password);
            flag = true;
        } catch (IllegalPasswordException e) {
            for(int i =0; i<e.getMessages().length;i++)
            {
                System.out.println(e.getMessages()[i]);
                assertEquals("wrong length",e.getMessages()[i]);
            }
            flag = false;
        } catch (IllegalArgumentException e){
            e.getMessage();
        }
        assertFalse(flag);

    }
    @Test
    public void wrongSymbolTest(){
        String password = null;
        boolean flag =false;
        try {
            checkPassword.check(password);
            flag = true;
        } catch (IllegalArgumentException  | IllegalPasswordException e) {
            flag = false;
            assertEquals("null",e.getMessage());
        }
        assertFalse(flag);

    }
    @Test
    public void wrongMissingSymbolsTest(){
        Map<String ,String[]> map = new LinkedHashMap<>();
        List<String> list = new LinkedList<>();


        list.add("kkkk&008-");// no upper case;
        list.add("JJJJJJ!678");//no lower case;
        list.add("jk89kloK");// no special symbol;
        list.add("999998765");//multi missing;

        for(int i =0; i<list.size();i++) {
            try {
                checkPassword.check(list.get(i));

            } catch (IllegalPasswordException e) {

                map.put(list.get(i),e.getMessages());
            }
        }

        String[] check = {"no upper case letter"};
        String[] check2 = {"no lower case letter"};
        String[] check3 ={"there is no special symbol"};
        String[] check4 ={"no upper case letter","no lower case letter","there is no special symbol"};
        List<String[]> list2 = new LinkedList<>();

        list2.add(check);
        list2.add(check2);
        list2.add(check3);
        list2.add(check4);
        int i = 0;
        for(Map.Entry<String,String[]> e : map.entrySet()){
           assertArrayEquals(list2.get(i),e.getValue());
           i++;
        }


    }



}