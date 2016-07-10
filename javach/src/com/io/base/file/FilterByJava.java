package com.io.base.file;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {

        // 是否以.java结束
        return name.endsWith(".java");
    }

}
