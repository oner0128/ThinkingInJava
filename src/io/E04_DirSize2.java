package io;

import java.io.File;

/**
 * Created by hrong on 2016/8/31.
 */
public class E04_DirSize2 {
    E04_DirSize2(File path,String regex){
        Directory.TreeInfo treeInfo=Directory.walk(path,regex);
        long totalSize=0;
        long size;
        for (File file :treeInfo.files){
            size=file.length();
            totalSize+=size;
            System.out.println(file.getName()+" "+size+" byte(s)");
        }
        System.out.println("-------------");
        System.out.println(treeInfo.files.size()+" file(s)"+totalSize+" byte(s)");
    }

    public static void main(String[] args) {
        E04_DirSize2 e04_dirSize2=new E04_DirSize2(new File("C:\\Users\\hrong\\IdeaProjects\\Thinking in Java\\src\\io"),".*");
    }
}
