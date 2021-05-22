package telran.security;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PasswordCheck {

    public static void check (String password) throws IllegalPasswordException, IllegalArgumentException{
        if(password == null) throw new IllegalArgumentException("null");

        List<String> arr = new LinkedList<>();

        if (password.length()<8){
            arr.add("wrong length");
        }
        if (!password.matches(".*[A-Z].*")){
            arr.add("no upper case letter");
        }
        if (!password.matches(".*[a-z].*")){
            arr.add("no lower case letter");
        }
        if (password.contains(" ")){
            arr.add("wrong symbol");
        }

        if(!(password.contains("§") || password.contains("!") || password.contains("@")|| password.contains("$")
                || password.contains("%")|| password.contains("^")|| password.contains("&")|| password.contains("*")
                || password.contains("(")|| password.contains(")")|| password.contains("=")|| password.contains("_")
                || password.contains("-")|| password.contains("+") || password.contains("{") || password.contains("}")
                || password.contains("[")|| password.contains("]") || password.contains("'")|| password.contains(":")
                || password.contains("|")|| password.contains("?")|| password.contains("/") || password.contains(";")
                || password.contains("#")|| password.contains("~")|| password.contains("`"))){

            arr.add("there is no special symbol");

        }
        String[] mistakes = new String[arr.size()];
        for(int i =0; i<arr.size();i++){
            mistakes[i] = arr.get(i);
        }

        if(!arr.isEmpty()) throw new IllegalPasswordException(mistakes);

    }



}
