package concurrency;

import java.util.Arrays;

/**
 * Created by hrong on 2016/9/14.
 */
class Fibonacci implements Runnable{
    private int count;
    private final int n;
    public Fibonacci(int n){
        this.n=n;
    }
    public Integer next(){return fib(count++);}

    private int fib(int n) {
        if (n<2)return 1;
        return fib(n-1)+fib(n-2);
    }

    @Override
    public void run() {
        Integer[] sequence=new Integer[n];
        for (int i = 0; i < n; i++) {
            sequence[i]=next();
        }
        System.out.println("Seq.of "+n+"："+ Arrays.toString(sequence));
    }
}
public class E02_Fibonacci2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            new Thread(new Fibonacci(i)).start();
        }
    }
}
