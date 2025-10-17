import java.util.Scanner;

public class Ch6{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String firstline = in.nextLine();
        //System.out.println(ppap(firstline));
        
        //String s = in.nextLine();
        //isPalindrome(s);
        
        //System.out.print("Input a positive integer to calculate binary: ");
        //int n = in.nextInt();
        //System.out.println(convertToBinary(n));
        
        System.out.print("Input a sentence to translate to pig latin: ");
        String english = in.nextLine();
        System.out.println(pigLatin(english));
    }
    
    public static String ppap(String str) {
        String object1 = str.substring(9, str.indexOf(","));
        String object2 = str.substring(str.lastIndexOf(" ")+1, str.indexOf("."));
        String up = object2.substring(0, 1).toUpperCase();
        String end = object2.substring(1, object2.length());
        
        String newString = "Uh! " + up + end + " " + object1 + ".";
        return newString;
    }
    
    public static boolean isPalindrome(String str) {
        String nonLetters = ",.:;()[]{}!?@#$%^&* ";
        String b = "";
        String lower = str.toLowerCase();
        String f = "";
        
        for (int i = str.length(); i > 0; i--) {
            if (!nonLetters.contains(lower.substring(i-1, i))) {
                b = b + lower.substring(i-1, i);
            }
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!nonLetters.contains(lower.substring(i, i+1))) {
                f = f + lower.substring(i, i+1);
            }
        }
        
        if (f.equals(b)) {
            System.out.println("It is a palindrome!");
            return true;
        } else {
            System.out.println("It is not a palindrome!");
            return false;
        }
    }
    
    public static String convertToBinary (int num) {
        String r = "";
        for (int i = num; i > 0; i=i/2) {
            int rmd = i%2;
            r = r + rmd;
        }
        
        String br = "";
        for (int i = r.length(); i > 0; i--) {
            br = br + r.substring(i-1, i);
        }
        return br;
    }
    
    public static String oneWord (String word) {
        String pig = "";
        String startLetter = word.substring(0, 1);
        String end = word.substring(1);
        String a = "ay";
        if (word.length() > 2) {
            pig += end + startLetter + a;
        } else {
            pig += word;
        }
        
        return pig;
    }
    
    public static String pigLatin (String msg) {
        String newPig = "";
        
        while (msg.indexOf(" ") >= 0) {
            int spaceIndex = msg.indexOf(" ");
            String word = msg.substring(0, spaceIndex);
            newPig += oneWord(word) + " ";
            msg = msg.substring(spaceIndex+1);   //chops the beginning off
        }
        newPig += oneWord(msg);
        
        return newPig;
    }
    
}