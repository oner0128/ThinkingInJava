package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/7/14.
 */
public class E13_fixStartEnd {
    public static String input = E12_Groups.POEM;

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display display = new Display(regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
//            display.display("find() '" + matcher.group() + "' at position :" + matcher.start() + "-" + (matcher.end() - 1));
            display.display("find() '" + matcher.group() + "' at position :" + matcher.start() + "-" + matcher.end());
            if (matcher.lookingAt()) {
                display.display("lookingAt()" + "at position :" + matcher.start() + "-" + matcher.end() );
            }
            if (matcher.matches()) {
                display.display("matches()" + "at position :" + matcher.start() + "-" + matcher.end());
            }
        }
    }

    public static void main(String[] args) {
        for (String s : input.split("\n")) {
            System.out.println("input:" + s);
            for (String regex : new String[]{"the", "\\w*ever", "T.*\\.", "T\\w+"}) {
                examine(s, regex);
            }
        }
    }
}
