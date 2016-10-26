package com.myjava.io.base.sequencestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/*
 *
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {
        /*
         * 需求：将1.txt,2.txt 3.txt 文件中的数据合并到一个文件中
         *
         */
        //        Vector<FileInputStream> v = new Vector<FileInputStream>();
        //        v.add(new FileInputStream("f:\\1.txt"));
        //        v.add(new FileInputStream("f:\\2.txt"));
        //        v.add(new FileInputStream("f:\\3.txt"));
        //        Enumeration<FileInputStream> en = v.elements();

        ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>();
        for (int x = 1; x <= 3; x++) {
            a1.add(new FileInputStream("f:\\" + x + ".txt"));
        }
        Enumeration<FileInputStream> en = Collections.enumeration(a1);
        // 内部类
        /*        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
                    ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>();
                    final Iterator<FileInputStream> it = a1.iterator();
                    @Override
                    public boolean hasMoreElements() {
                        return it.hasNext();
                    }
                    @Override
                    public FileInputStream nextElement() {
                        return it.next();
                    }
                };*/
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream("f:\\4.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
}
