package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/8/30.
 */
public class Directory {
    public static File[]
    local(File dir, String regex){
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(regex,name);
            }
        });
    }
    public static File[]
    local(String path,String regex){
        return local(new File(path),regex);
    }
    public static class TreeInfo implements Iterator<File>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public File next() {
            return null;
        }

        public List<File> files=new ArrayList<File>();
        public List<File> dirs=new ArrayList<>();
        public Iterator<File> iterator(){
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString() {
            return "dirs: "+ dirs.toString()+"\n\nfiles: "+files.toString();
        }
    }
    public static TreeInfo
    walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }
    public static TreeInfo
    walk(File start,String regex){
        return recurseDirs(start,regex);
    }
    public static TreeInfo
    walk(File start){
        return recurseDirs(start,".*");
    }

     static TreeInfo recurseDirs(File startDir, String regex) {
         TreeInfo result=new TreeInfo();
         for (File item :startDir.listFiles()){
             if(item.isDirectory()){
                 result.dirs.add(item);
                 result.addAll(recurseDirs(item,regex));
             }else
                 if (item.getName().matches(regex))
                     result.files.add(item);
         }
         return result;
    }
}
