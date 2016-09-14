package io;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hrong on 2016/9/1.
 */
public class E19_BytesInfo {
    static String file="C:\\Users\\hrong\\Desktop\\io.txt";
    public static void main(String[] args) throws IOException {
        Map<Byte,Integer> byteInfos=new HashMap<>();
        byte[] bytes=BinaryFile.read(new File(file));
        for (Byte b :bytes){
        Integer integer=byteInfos.get(b);
            byteInfos.put(b,integer==null?1:++integer);
        }
        System.out.println(byteInfos);
    }
}
