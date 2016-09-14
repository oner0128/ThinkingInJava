package io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/9/10.
 */
public class E26_JGrepMM {
    public static void main(String[] args) throws Exception {

        Pattern p = Pattern.compile(".*");
        FileChannel fc =
                new FileInputStream("E14_BasicFileOutout3.java").getChannel();
        ByteBuffer buffer =
                fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        CharBuffer cb = Charset.forName(
                System.getProperty("file.encoding")).decode(buffer);
        String[] fileAsArray = cb.toString().split("\n");
        int index = 0;
        Matcher m = p.matcher("");
        for(String line : fileAsArray) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " + m.group() +
                        ": " + m.start());
        }
        fc.close();
    }
}
