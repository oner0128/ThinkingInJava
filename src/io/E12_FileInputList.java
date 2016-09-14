package io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by hrong on 2016/8/31.
 */
public class E12_FileInputList {
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
             strings.listIterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
//        System.out.println(strings);
    }
    public static void write(File path,List<String> strings){
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(path));
            String s;
            for (ListIterator<String> it =
                 strings.listIterator(); it.hasNext(); ) {
                s="行号："+it.nextIndex()+"， 内容："+it.next();
                out.write(s+"\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        if (args.length != 1) {
//            System.err.println("Usage: java E08_FileInputList2.java");
//            return;
//        }
        File file=new File("C:\\Users\\hrong\\Desktop\\io.txt");
        display(read(file));
        System.out.println("After write()");
        write(file,read(file));
        display(read(file));
    }
}
