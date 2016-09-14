package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/7/14.
 */
public class E10_regex {
    public static void main(String[] args) {
        String str = "Java now has regular expressions";
        String[] regexs = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"};
        System.out.println("Input:\"" + str + "\"");
        for (String s : regexs) {
            Matcher matcher = Pattern.compile(s).matcher(str);
            System.out.println("Regular expressions:\"" + s + "\"");
//            System.out.print("     maches()--");
//            System.out.print(matcher.matches());
//            System.out.print("     lookingat()--");
//            System.out.println(matcher.lookingAt());
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at position " + matcher.start() + "-" + (matcher.end() - 1));
            }
        }
    }

}

