import java.util.HashMap;

public class a1x4PalindromePermutation {

    public static boolean isPermutationOfAPalindrome(String str){
        str = str.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        int countOf1s = 0 ;
        for(char c : map.keySet()){
            int count = map.get(c);
            if(count==1) countOf1s++;
            else{
                return false;
            }
        }
        return countOf1s==1;
    }
    public static void fillHMWithCharCount(HashMap<Character, Integer> map, String str){
        for(int i = 0 ; i<str.length();i++){
            char c = str.charAt(i);
            if(c==' ') continue;
            if(map.containsKey(c)) map.put(c,map.get(c)+1);
            else{
                map.put(c,1);
            }
        }
    }

}
