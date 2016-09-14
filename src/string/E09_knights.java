package string;

import java.util.Arrays;

/**
 * Created by hrong on 2016/7/13.
 */
public class E09_knights {
    public String split(String regex){
        String knihts="Then, when you have found the shrubbery, you must "+
                "cut down the mightiest tree in the forest... "+
                "with... a herring!";
        return Arrays.toString(knihts.split(regex));
    }
    public static void main(String[] args) {
        String knihts="Then, when you have found the shrubbery, you must "+
                "cut down the mightiest tree in the forest... "+
                "with... a herring!";

        System.out.println(knihts.replaceAll("(?i)[aeiou]","_"));
    }
}
