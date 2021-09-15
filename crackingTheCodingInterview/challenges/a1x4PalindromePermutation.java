import java.util.HashMap;

public class a1x4PalindromePermutation {

    public static boolean isPermutationOfAPalindrome(String str){
        str = str.toLowerCase();
        //System.out.println(str);
        HashMap<Character, Integer> map = new HashMap<>();
        int countOf1s = 0 ;
        fillHMWithCharCount(map,str);
        for(char c : map.keySet()){
            //System.out.println(c + " count " + map.get(c));
            int count = map.get(c);
            if(count==2) continue;
            else if(count==1) countOf1s++;
            else{
                return false;
            }
        }
        return countOf1s<=1;
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
