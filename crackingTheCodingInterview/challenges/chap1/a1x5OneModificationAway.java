package chap1;

import java.util.HashMap;

public class a1x5OneModificationAway {
    public static boolean areOneAway(String a, String b){
        if (a.equals(b)) return true;
        if(Math.abs(a.length()-b.length())>1) return false;
        return numOfDifferences(a,b)<=1;
    }
    public static int numOfDifferences(String a, String b){
        int result = 0;
        int aPointer = 0 ;
        int bPointer = 0;

        while(aPointer<a.length() && bPointer<b.length()){
            char aCurr = a.charAt(aPointer);
            char bCurr = b.charAt(bPointer);
            if(aCurr==bCurr){
                aPointer++;
                bPointer++;
                continue;
            }
            if(bPointer+1<b.length() && aCurr==b.charAt(bPointer+1)){
                result++;
                bPointer+=2;
                aPointer+=2;
                continue;
            }
            if(aPointer<a.length() && bCurr==a.charAt(aPointer+1)){
                result++;
                aPointer+=2;
                bPointer+=2;
                continue;
            }
            result++;
            aPointer++;
            bPointer++;
        }
        //result+=Math.abs(aPointer-a.length() + bPointer-a.length());
        System.out.println("differences is: " + result);
        return result;
    }
    /**
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
            System.out.println("number of differences: " + result);

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
        System.out.println("number of differences: " + result);
        return result;
    }
     **/
}
