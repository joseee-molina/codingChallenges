public class a1x9stringRotation {

    public static boolean isStringRotation(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        String text = s1+s1;
        return text.contains(s2);
    }
    //this is a very very fast and clever solution!!
}
