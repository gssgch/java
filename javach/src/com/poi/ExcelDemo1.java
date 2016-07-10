package com.poi;

import java.io.FileInputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class ExcelDemo1 {

    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("F:\\30年后，你拿什么养活自己.doc");
        WordExtractor extractor = new WordExtractor(in);
        String str = extractor.getText();
        //System.out.println("the result length is"+str.length());
        System.out.println(str);
    }

}
