package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by hrong on 2016/8/30.
 */
public class E02_SortedDirList {
    public static void main(String[] args) {
        SortedDirList driList=new SortedDirList(new File("C:\\Users\\hrong\\IdeaProjects\\Thinking in Java\\src\\io"));
        System.out.println(Arrays.asList(driList.list("E0[123]_.*\\.java")));
        System.out.println("--------");
        System.out.println(Arrays.asList(driList.list()));
    }
}
class SortedDirList {
    private File path;
    public SortedDirList(){path=new File(".");}
    public SortedDirList(File path){this.path=path;}
    public String[] list(){
        String[] list=path.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        return list;
    }
    public String[] list(String fn_regex){
        String[] list=path.list(new FilenameFilter() {
            private Pattern pattern=Pattern.compile(fn_regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        return list;
    }
}
