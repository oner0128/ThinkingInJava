package string;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/7/14.
 */
public class E12_Groups {
    public static final String POEM = "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrade.\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\b\\p{Upper}[a-z]+\\b").matcher(POEM);
        int count = 0;
        while (matcher.find()) {
//            for (int i = 0; i <=matcher.groupCount() ; i++) {
//                System.out.println("["+matcher.group(i)+"]");
//            }
            System.out.print("[" + matcher.group() + "]\t");
            count++;
        }
        System.out.println("\n以大写字母开头的词的数目(重复计数)：" + count);
        Matcher matcher2 = Pattern.compile("\\b\\p{Lower}[a-z]+\\b").matcher(POEM);
        Set<String> counts = new HashSet<>();
        while (matcher2.find()) {
//            for (int i = 0; i <=matcher.groupCount() ; i++) {
//                System.out.println("["+matcher.group(i)+"]");
//            }
//            System.out.print("["+matcher2.group()+"]\t");
            counts.add(matcher2.group());
        }
        System.out.println(counts.toString());
        System.out.println("\n不以大写字母开头的词的数目（不重复计数）：" + counts.size());
    }
}


