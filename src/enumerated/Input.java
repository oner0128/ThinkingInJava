package enumerated;


import java.util.Random;

/**
 * Created by hrong on 2016/9/12.
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        public int amount(){
            throw new RuntimeException("ABORT.amout()");
        }
    },
    STOP {
        public int amount(){
        throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;
    Input(){}
    Input(int value) {
        this.value=value;
    }
    int amount(){return value;};
    static Random random=new Random(47);
    public static Input randomSelection(){
        return values()[random.nextInt(values().length-1)];
    }
}
