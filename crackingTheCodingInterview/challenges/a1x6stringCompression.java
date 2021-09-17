public class a1x6stringCompression {

    public static String compressString(String a){
        String result = "";
        int i = 0 ;
        int numOfCharsOfC = 0;
        while(i<a.length()){
            char c = a.charAt(i);
            numOfCharsOfC = numOfCharsFromHere(i,c,a);
            i+=numOfCharsOfC;
            result+= c+Integer.toString(numOfCharsOfC);
        }
        return result.length()>a.length() ? a : result;
    }

    public static int numOfCharsFromHere(int i, char c, String a){
        int result=0;
        while(i<a.length() && a.charAt(i)==c){
            result++;
            i++;
        }
        return result;
    }

}
