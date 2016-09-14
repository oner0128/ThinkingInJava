package io;

import java.io.*;

/**
 * Created by hrong on 2016/9/10.
 */
class Thing1 implements Serializable{
    private Thing2 next;
    public Thing1(int id){next=new Thing2(id);}
    public String toString(){
        StringBuilder result=new StringBuilder("Thing1(Thing2(");
        result.append(next);
        result.append("))");
        return result.toString();
    }
}
class Thing2 implements Serializable{
    private int id;
    public Thing2(int id){
        this.id=id;
    }
    public String toString(){return Integer.toString(id);}
}
public class E27_ObjectSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Thing1 thing1=new Thing1(1);
        System.out.println("t1="+thing1);
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("thing1.out"));
        out.writeObject("Thing1 storage\n");
        out.writeObject(thing1);
        out.close();
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("thing1.out"));
        String s= (String) in.readObject();
        Thing1 thing2= (Thing1) in.readObject();
        System.out.println(s+"t2= "+thing2);
        ByteArrayOutputStream bout =
                new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Thing1 storage\n");
        out2.writeObject(thing1);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        Thing1 thing3 = (Thing1)in2.readObject();
        System.out.println(s + "thing3 = " + thing3);
    }
}
