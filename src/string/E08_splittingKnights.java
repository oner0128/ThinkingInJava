package string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hrong on 2016/7/13.
 */
public class E08_splittingKnights {
    public static void main(String[] args) {
        String knihts="Then, when you have found the shrubbery, you must "+
                "cut down the mightiest tree in the forest... "+
                "with... a herring!";
        System.out.println(knihts);
        System.out.println(Arrays.toString(knihts.split(" ")));
        System.out.println(Arrays.toString(knihts.split("the|you")));
    }
}
