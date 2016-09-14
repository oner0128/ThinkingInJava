package io;

import java.io.*;

/**
 * Created by hrong on 2016/8/31.
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\hrong\\Desktop\\io.txt";
        File file = new File(fileName);
        BufferedReader in = new BufferedReader(new FileReader(file));
       PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(s);
            out.println(lineCount++ + ": " + s+"\n");
        }
        out.close();
    }
}
