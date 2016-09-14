package string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Created by hrong on 2016/7/13.
 * 讲结果输出到SYSTEM.ERR中
 * 结果：ERR的输出优先于OUT
 */
public class Turtle {
    private String name;
    private Formatter formatter;
    public  Turtle(String name,Formatter formatter){
        this.name=name;
        this.formatter=formatter;
    }
    public void move(int x,int y){
        formatter.format("%s The turtle is at [%d,%d]\n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream outAlias=System.err;
        Turtle toommy=new Turtle("tommy",new Formatter(System.out));
        Turtle terry=new Turtle("terry",new Formatter(outAlias));
        toommy.move(0,0);
        terry.move(3,3);
        toommy.move(3,0);
        terry.move(0,3);
        toommy.move(1,2);
        terry.move(0,3);

    }
}
