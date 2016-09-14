package io;


import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hrong on 2016/9/10.
 */
public class E32_WordIntoXML {
    static Element getXML(Map.Entry<String,Integer> me){
        Element record=new Element("record");
        Element word=new Element("word");
        word.appendChild(me.getKey());
        Element freq=new Element("frequency");
        freq.appendChild(me.getValue().toString());
        record.appendChild(word);
        record.appendChild(freq);
        return record;
    }
    public static void
    format(OutputStream os, Document doc) throws Exception {
        Serializer serializer= new Serializer(os,"ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }
    public static void main(String[] args) throws Exception {
        Map<String,Integer> wordsStat=
                new HashMap<>();
        for (String word:
                new TextFile("E32_WordIntoXML.java","\\W+"))
        {
            Integer freq=wordsStat.get(word);
            wordsStat.put(word,freq==null?1:freq+1);
        }
        Element root=new Element("words");
        for (Map.Entry<String,Integer> me : wordsStat.entrySet()){
            root.appendChild(getXML(me));
        }
        Document doc=new Document(root);
        format(System.out,doc);
        format(new BufferedOutputStream(new FileOutputStream("WordsInfo.xml")), doc);
    }
}
