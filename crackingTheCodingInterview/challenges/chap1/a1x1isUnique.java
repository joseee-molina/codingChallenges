package chap1;

import java.util.HashSet;

public class a1x1isUnique {
    public static boolean hasUniqueChars(String s){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i<s.length(); i++){
            char currentChar = s.charAt(i);
            if(set.contains(currentChar)) return false;
            set.add(currentChar);
        }
        return true;
    }

}
