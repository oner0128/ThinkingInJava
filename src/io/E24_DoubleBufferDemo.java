package io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Created by hrong on 2016/9/3.
 */
public class E24_DoubleBufferDemo {
     static final int BSIZE=1024;

    public static void main(String[] args) {
        ByteBuffer bb=ByteBuffer.allocate(BSIZE);
        DoubleBuffer db=bb.asDoubleBuffer();
        db.put(new double[]{10.555d,454.55,55454.1d,45455.213,456465.1258,98989.11});
        System.out.println(db.get(3));
        db.put(3,1111.11111d);
        db.flip();
        while (db.hasRemaining()){
            double d=db.get();
            System.out.println(d);
        }
    }
}
