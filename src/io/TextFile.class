package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hrong on 2016/8/30.
 */
public class TextFile extends ArrayList<String> {
    public TextFile(String filename, String splitter) {
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String filename) {
        this(filename, "/n");
    }

    public static String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.println(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
