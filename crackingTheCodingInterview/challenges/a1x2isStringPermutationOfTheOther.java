import java.util.*;

public class a1x2isStringPermutationOfTheOther {
    public static boolean isPermutation(String a, String b){
        HashMap<Character, Integer> amap  = new HashMap<>();
        HashMap<Character, Integer> bmap  = new HashMap<>();
        fillHMwithString(amap,a);
        fillHMwithString(bmap,b);
        return amap.equals(bmap);
    }

    public static void fillHMwithString(HashMap<Character,Integer> amap, String a){
        for(int  i = 0 ; i<a.length();i++){
            char c = a.charAt(i);
            if(amap.containsKey(c)){
                amap.put(c,amap.get(c)+1);
            }
            else{
                amap.put(c,1);
            }
        }
    }

    public static boolean stringPermutationConstantSolution(String a, String b){
        if(a.length()!=b.length()){
            return false;
        }
        if(a.length()>128){
            return false;
        }
        int[] characters = new int[128];
        for(int i = 0 ; i<a.length();i++){
            characters[a.charAt(i)]++;
        }
        for(int i = 0 ; i<b.length();i++){
            characters[b.charAt(i)]--;
            if(characters[b.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }



}
