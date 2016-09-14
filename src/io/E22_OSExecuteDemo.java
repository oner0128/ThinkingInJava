package io;

import com.sun.corba.se.impl.logging.OMGSystemException;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrong on 2016/9/2.
 */

public class E22_OSExecuteDemo {

        public static void commandCD(String command) throws IOException {
            Process process = new ProcessBuilder(command.split(" ")).start();
        }

        public static List<String> command(String command) {
            List<String> stringList = new ArrayList<>();
            boolean err = false;
            try {
                Process process = new ProcessBuilder(command.split(" ")).start();
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s;
                while ((s = in.readLine()) != null)
                    stringList.add(s);
                BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while ((s = in.readLine()) != null) {
                    System.err.println(s);
                    err = true;
                }
            } catch (IOException e) {
                if (!command.startsWith("CMD /C"))
                    command("CMD /C " + command);
                else
                    throw new RuntimeException(e);
            }
            if (err)
                System.err.println("Erorrs executing " + command);
            return stringList;
        }



    public static void main(String[] args) throws IOException {
//        commandCD("C:\\Users\\hrong\\IdeaProjects\\Thinking in Java");
        List<String> output = command(
                "javap E22_OSExecuteDemo.class");
        System.out.println(output);
    }
}