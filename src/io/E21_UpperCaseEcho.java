package io;

import java.io.*;

/**
 * Created by hrong on 2016/9/2.
 */
public class E21_UpperCaseEcho {
    static String file="C:\\Users\\hrong\\Desktop\\io.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
            out.write(s);
        }
        in.close();
        out.close();
    }
}
