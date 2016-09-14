package io;

import java.io.*;

/**
 * Created by hrong on 2016/8/31.
 */
public class E13_BasicFileOutput2 {
    static String file="E13_CountLines.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader in=new LineNumberReader(new FileReader("C:\\Users\\hrong\\Desktop\\E13_BasicFileOutput2.java"));
        PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String s;
        while ((s=in.readLine())!=null){
            out.println(in.getLineNumber()+": "+s);
        }
        out.close();
        System.out.println(E07_FileInputList.read(new File(file)));
    }
}

