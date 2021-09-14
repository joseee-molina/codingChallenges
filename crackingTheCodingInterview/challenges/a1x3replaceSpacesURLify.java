public class a1x3replaceSpacesURLify {
    public static char[] replaceSpaces(char[] arr){
        moveWordsToTheRight(arr);
        int i = 0;
        while(i<arr.length-3){
            if(arr[i]==' '){
                arr[i]='%';
                arr[i+1] = '2';
                arr[i+2] = '0';
                i+=3;
                continue;
            }
            i++;
        }
        printCharArr(arr);
        return arr;
    }

    public static void moveWordsToTheRight(char[] arr){
        int i = arr.length-1;
        int j = arr.length-1;
        j = moveJLeft(j,arr);
        while(j>0){
            if(arr[j]==' ') i-=3;
            j = moveJLeft(j,arr);
            swapCharArrayPositions(i,j,arr);
            i--;
            j--;
        }
       // printCharArr(arr);
    }

    static void printCharArr(char[] arr){
        for(char c : arr){
            System.out.print(c);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void swapCharArrayPositions(int i , int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int moveJLeft(int j, char[] arr){
        while(arr[j]==' '){
            j--;
        }
        return j;
    }


}
