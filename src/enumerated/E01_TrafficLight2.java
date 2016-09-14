package enumerated;

/**
 * Created by hrong on 2016/9/11.
 */
import static enumerated.Signal.*;
public class E01_TrafficLight2 {
    Signal color=GREEN;
    public void chang(){
        switch (color){
            case GREEN: color=RED;break;
            case RED:color=YELLOW;break;
            case YELLOW:color=GREEN;break;
        }
    }
    public String toString(){
        return "The Traffic signal color is " +color;
    }

    public static void main(String[] args) {
        E01_TrafficLight2 e01_trafficLight2=new E01_TrafficLight2();
        for (int i = 0; i < 10; i++) {
            System.out.println(e01_trafficLight2);
            e01_trafficLight2.chang();
        }
    }
}
