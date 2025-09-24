package firstlab;

public class Palindrome {
    public static void main(String[ ] args) {
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        String r_string = "";
        for (int i = s.length() - 1; i >= 0; i--){
                r_string = r_string + s.charAt(i);
        }
        return r_string;
    }
    public static boolean isPalindrome(String s){
        String s_reverse = reverseString(s);
        if (s.equals(s_reverse)){
            return true;
        }
        return false;
    }
}
