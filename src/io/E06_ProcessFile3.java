package io;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hrong on 2016/8/31.
 */
public class E06_ProcessFile3 {
    public static void main(String[] args) {
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        long tmp=0;
        try {
            dateFormat.setLenient(false);
            tmp=dateFormat.parse("8/30/2016").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final long modTime=tmp;
        new ProcessFile2(new ProcessFile2.Strategy() {
            @Override
            public void process(File file) {
                long lastTime=file.lastModified();
                if (lastTime>modTime)
                    System.out.println(file+" lastModified time >= 8/30/2016");
            }
        },".*\\.java").start(".");
    }
}
