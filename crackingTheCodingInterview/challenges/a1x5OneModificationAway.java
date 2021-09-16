import java.util.HashMap;

public class a1x5OneModificationAway {
    public static boolean areOneAway(String a, String b){
        if (a.equals(b)) return true;
        if(Math.abs(a.length()-b.length())>1) return false;
        HashMap<Character,Integer> amap = new HashMap<>();
        HashMap<Character,Integer> bmap = new HashMap<>();
        fillHMwithString(amap,a);
        fillHMwithString(bmap,b);
        return countNumberOfDifferences(amap,bmap) <= 1;
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
    public static int countNumberOfDifferences(HashMap<Character,Integer> amap, HashMap<Character,Integer> bmap){
        int result = 0;
        if(amap.size()>bmap.size()){
            for(char c : amap.keySet()){
                if(!bmap.containsKey(c)){
                    result+=amap.get(c);
                }
                else{
                    result += Math.abs(amap.get(c) - bmap.get(c));
                }
            }
            return result;
        }
        for(char c : bmap.keySet()){
            if(!amap.containsKey(c)){
                result+=bmap.get(c);
            }
            else{
                result += Math.abs(amap.get(c) - bmap.get(c));
            }
        }
        return result;
    }
}
