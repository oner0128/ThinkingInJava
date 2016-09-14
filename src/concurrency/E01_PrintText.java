package concurrency;

/**
 * Created by hrong on 2016/9/14.
 */
public class E01_PrintText implements Runnable {
    private static int taskcount=1;
    private final int id=taskcount++;
    E01_PrintText(){
        System.out.println("PrintText "+id+" begins ");
    }
    @Override
    public void run() {
        for (int i = 1; i <=3; i++) {
            System.out.println("It's id :"+id +" -- "+i+" time(s)");
            Thread.yield();
        }
        System.out.println("PrintText "+id +" ends");
    }

    public static void main(String[] args) {
        for (int i = 0; i <9; i++) {
            new Thread(new E01_PrintText()).start();
        }
    }
}
