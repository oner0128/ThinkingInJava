package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hrong on 2016/8/29.
 */
public class E01_DirList {
    public static void main(String[] args) {
        File path = new File(".");//获取当前的路径
        String[] list;
        if(args.length==0)
            list=path.list();//获取当前路径下的所有目录或文件名
        else
            list=path.list(new FilenameFilter() {
                private String ext=args[0].toLowerCase();
                @Override
                public boolean accept(File dir, String name) {
                    if (name.toLowerCase().endsWith(ext))
                    {
                        if (args.length==1)
                            return true;
                        Set<String> words=new HashSet<String>(new TextFile(new File(name).getAbsolutePath(),"\\W+"));
                        for (int i = 1; i < args.length; i++) {
                            if (words.contains(args[i]))
                                return true;
                        }
                    }
                    return false;
                }
            });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s:list){
            System.out.println(s);
        }
    }
}

