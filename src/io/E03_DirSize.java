package io;

import java.io.File;
import java.util.Arrays;

/**
 * Created by hrong on 2016/8/30.
 */
public class E03_DirSize {
    E03_DirSize(String fileName){
        File path=new File(fileName);
        String[] list=path.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        long totalSize=0;
        for (int i = 0; i < list.length; i++) {
            long size=new File(path,list[i]).length();//获取当前路径下的第i个文件或目录的大小
            totalSize+=size;
            System.out.println(list[i]+"  "+size+" byte(s)");
        }
        System.out.println(list.length+" file(s)  "+totalSize+" byte(s)");
    }

    public static void main(String[] args) {
        E03_DirSize e03_dirSize =new E03_DirSize("C:\\Users\\hrong\\IdeaProjects\\Thinking in Java\\src\\io");
        E03_DirSize e03_dirSize2 =new E03_DirSize(".");
    }
}
