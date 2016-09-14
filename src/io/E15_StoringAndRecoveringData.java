package io;

import java.io.*;

/**
 * Created by hrong on 2016/9/1.
 */
public class E15_StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\hrong\\Desktop\\io.java")));
        out.writeBoolean(false);
        out.writeChar(65);
        out.writeFloat( 3.14159f);
        out.writeUTF("That is pi");
        out.writeByte(255);
        out.writeChars("C");
        out.writeLong(4546555);
        out.close();
        DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\hrong\\Desktop\\io.txt")));
        System.out.println(in.readBoolean());
        System.out.println(in.readChar());
        System.out.println(in.readFloat());
        System.out.println(in.readUTF());
        System.out.println(in.readByte());
        System.out.println(in.readChar());
        System.out.println(in.readLong());
    }
}
