package io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hrong on 2016/9/1.
 */
public class E17_CharactersInfo {
    static String file="C:\\Users\\hrong\\Desktop\\io.txt";
    public static void main(String[] args) {
        String s=TextFile.read(file);
        StringBuilder stringBuilder=new StringBuilder(s);
        int charValue=1;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            Character c=stringBuilder.charAt(i);
//            if (map.containsKey(c)){
//                int tmp =map.get(c);
//                tmp++;
//                map.put(c,tmp);
//            }else {
//               map.put(c,charValue);
//            }
            Integer integer=map.get(c);
            map.put(c,integer==null?1:++integer);
        }
        System.out.println(map);
        System.out.println(map.get("a"));
    }
}
