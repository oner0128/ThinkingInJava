package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrong on 2016/7/13.
 * 修复InfiniteRecursion.java
 */
public class InfiniteRecursion {
    public String toString(){
        return "infiniteRecursion address:"+super.toString();
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> infiniteRecursions=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            infiniteRecursions.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursions);
    }
}
