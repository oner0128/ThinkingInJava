package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by hrong on 2016/8/31.
 */
public class E05_ProcessFile2 {
    public static void main(String[] args) {
        new ProcessFile2(new ProcessFile2.Strategy(){
            public void process(File file) {System.out.println(file);}
        },".*\\.java").start(args);
    }
}
class ProcessFile2 {
    public interface Strategy{
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFile2(Strategy strategy, String ext){
        this.strategy=strategy;
        this.ext=ext;
    }
    public void start(String[] args){
        try {
            if (args.length==0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args){
                    File fileArg=new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else{
                        if (!arg.matches(ext))
                            strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void start(String arg){
        try {
            File fileArg=new File(arg);
            if (fileArg.isDirectory())
                processDirectoryTree(fileArg);
            else{
                if (!arg.matches(ext)) strategy.process(new File(arg).getCanonicalFile());
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root)throws IOException{
        for (File file : Directory.walk(root.getAbsoluteFile(),ext).files)
            strategy.process(file.getCanonicalFile());
    }
}
