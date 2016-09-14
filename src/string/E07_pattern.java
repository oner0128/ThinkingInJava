package string;

import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/7/13.
 */
public class E07_pattern {
    public static void main(String[] args) {
        String str="She's beautiful.";
        String str2="she's beautiful";
        boolean b= Pattern.matches("\\p{Lu}.*\\.",str);
        boolean b2= Pattern.matches("\\p{Upper}.*\\.",str);
        System.out.println(b);
        System.out.println(b2);
        boolean b3 = Pattern.matches("a*b", "aaaaab");
        System.out.println(b3);
    }
}
