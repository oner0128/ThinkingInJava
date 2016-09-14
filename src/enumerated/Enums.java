package enumerated;

import java.util.Random;

/**
 * Created by hrong on 2016/9/11.
 */
public class Enums {
    private static Random rand=new Random(47);
    public static <T extends Enum<T>> T random(Class<T> kind){
        return random(kind.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
