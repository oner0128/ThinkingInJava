package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/7/14.
 */
public class E11_checkRegex {
    public static void main(String[] args) {
        String str = "Arline ate eight apples and one orange while Anita hadn't \rany";
        String regexs = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        System.out.println("Input:\"" + str + "\"");

        Matcher matcher = Pattern.compile(regexs).matcher(str);
        System.out.println("Regular expressions:\"" + regexs + "\"");
//            System.out.print("     maches()--");
//            System.out.print(matcher.matches());
//            System.out.print("     lookingat()--");
//            System.out.println(matcher.lookingAt());
        while (matcher.find()) {
            System.out.println("Match \"" + matcher.group() + "\" at position " + matcher.start() + "-" + (matcher.end() - 1));
        }
    }
}
