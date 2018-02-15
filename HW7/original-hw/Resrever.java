public class Resrever {

public static String linReverse( String str ){ //algo that runs in O(n)
        String retStr = str.substring( str.length() );
        for (int i = str.length() - 1; i >= 0; i--) {
                retStr += str.substring(i, i+1);
        }
        return retStr;
}

public static String logReverse( String str ){
        return str;
}

public static void main(String[] args) {
        System.out.println( linReverse("stressed") );
}

}//end class StringMethods
