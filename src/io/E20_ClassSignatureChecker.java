package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by hrong on 2016/9/1.
 */
public class E20_ClassSignatureChecker {
    static byte[] signature={(byte) 202, (byte) 254, (byte) 186, (byte) 190};

    public static void main(String[] args) throws IOException {
        String dir="C:\\Users\\hrong\\IdeaProjects\\Thinking in Java\\src\\io";
        for (File file: Directory.walk(dir,".*\\.class").files){
            byte[] bt=BinaryFile.read(file);
            for (int i = 0; i < signature.length; i++) {
                if (bt[i]!=signature[i])
                    System.err.println(file+" is corrupt!");
                break;
            }
        }
    }
}
