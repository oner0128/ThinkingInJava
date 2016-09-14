package string;

/**
 * Created by hrong on 2016/7/13.
 */
public class E06_StringFormat {
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    E06_StringFormat(int anInt, long aLong, float aFloat, double aDouble){
        this.anInt=anInt;
        this.aLong=aLong;
        this.aFloat=aFloat;
        this.aDouble=aDouble;
    }
    public String toString(){
        return String.format("int=%5d ,long=%-10d ,float=%-5.3f ,double=%5.3e\n",anInt,aLong,aFloat,aDouble);
    }

    public static void main(String[] args) {
        E06_StringFormat e06StringFormat =new E06_StringFormat(50,5000000,1,1212.1235532158899);
        System.out.println(e06StringFormat.toString());
    }
}
