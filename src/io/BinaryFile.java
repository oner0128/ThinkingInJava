package io;

import java.io.*;

/**
 * Created by hrong on 2016/9/1.
 */
public class BinaryFile {
    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(bfile));
        try {
            byte[] bytes=new byte[in.available()];
            in.read(bytes);
            return bytes;
        }finally {
            in.close();
        }
    }
    public static byte[] read(String bfile)throws IOException{
        return read(new File(bfile).getAbsolutePath());
    }
}
