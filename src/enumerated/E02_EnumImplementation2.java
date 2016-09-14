package enumerated;

import java.util.*;

/**
 * Created by hrong on 2016/9/11.
 */
enum CartoonCharacter {
    SLAYY,SPANKY,PUNCHT,SILLY,BOUNCY,NUTTY,BOB;
    private static Random random=new Random(20);
    public static CartoonCharacter  next(){
        return values()[random.nextInt(values().length)];
    }
}
public class E02_EnumImplementation2 {
        public static  void printNext(){
            System.out.println(CartoonCharacter.next()+", ");
        }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printNext();
        }
    }
}
