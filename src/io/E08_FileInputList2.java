package io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by hrong on 2016/8/31.
 */
public class E08_FileInputList2 {
    public static List<String> read(File path) {
        List<String> strings = new LinkedList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String s;
            while ((s = in.readLine()) != null) {
                strings.add(s);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static void display(List<String> strings) {
        for (ListIterator<String> it =
             strings.listIterator(strings.size()); it.hasPrevious(); ) {
            System.out.println(it.previous());
        }
//        System.out.println(strings);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java E08_FileInputList2.java");
            return;
        }
        display(read(new File(args[0])));
    }
}
