package string;

import java.util.Arrays;

/**
 * Created by hrong on 2016/7/14.
 */
public class E14_ModifySplitDemo {
    public static void main(String[] args) {
        String input="This!!unusyak use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        System.out.println(Arrays.toString(input.split("!!",3)));
    }
}
