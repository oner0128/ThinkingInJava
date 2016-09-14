package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hrong on 2016/9/1.
 */
public class E18_TextFile2 extends ArrayList<String> {
    public E18_TextFile2(String filename, String splitter) throws IOException {
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public E18_TextFile2(String filename) throws IOException {
        this(filename, "/n");
    }

    public static String read(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
        String s;
        ;
        try {
            while ((s = in.readLine()) != null) {
                stringBuilder.append(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return stringBuilder.toString();
    }


    public static void write(String fileName, String text) throws IOException {

        PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
        try {
            out.println(text);
        } finally {
            out.close();
        }
    }
}
