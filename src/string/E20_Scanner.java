package string;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by hrong on 2016/7/14.
 */
public class E20_Scanner {
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private String aString;
    E20_Scanner(String s){
//        BufferedReader bufferedReader=new BufferedReader(new StringReader(s));
        Scanner scanner=new Scanner(s);
        this.anInt=scanner.nextInt();
        this.aLong=scanner.nextLong();
        this.aFloat=scanner.nextFloat();
        this.aDouble=scanner.nextDouble();
        this.aString=scanner.next();
    }
    public String toString(){
        return "E20_Scanner -- anInt:"+anInt+"\taLong:"+aLong+"\taFloat:"+aFloat+"\taDouble:"+aDouble+"\taString:"+aString;
    }

    public static void main(String[] args) {
        E20_Scanner e20_scanner=new E20_Scanner(" 12 255666655 1.00 45.2656 this");
        System.out.println(e20_scanner.toString());
    }
}
