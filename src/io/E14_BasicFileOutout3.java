package io;

import java.io.*;
import java.util.List;

/**
 * Created by hrong on 2016/8/31.
 */
public class E14_BasicFileOutout3 {
    static String file = "E14_BasicFileOutout3.out";

    public static void main(String[] args) throws IOException {
//        LineNumberReader in=new LineNumberReader(new FileReader("C:\\Users\\hrong\\Desktop\\E14_BasicFileOutout3.java"));
        List<String> list = E07_FileInputList.read(new File("E14_BasicFileOutout3.java"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int countLine = 1;
        long t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++) {
                out.println(countLine + ": " + s);
            }
            countLine++;
        }
        long t2 = System.currentTimeMillis();
        out.close();
        System.out.println(("buffered: " + (t2 - t1)));

        PrintWriter out2 = new PrintWriter(new FileWriter(file));
        countLine = 1;
        t1 = System.currentTimeMillis();
        for (String s : list) {
            for (int i = 0; i < 10000; i++) {
                out.println(countLine + ": " + s);
            }
            countLine++;
        }
        t2 = System.currentTimeMillis();
        out.close();
        System.out.println(("unbuffered: " + (t2 - t1)));
    }
}


