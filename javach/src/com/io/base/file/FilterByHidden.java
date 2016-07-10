package com.io.base.file;

import java.io.File;
import java.io.FilenameFilter;

// 过滤隐藏文件
public class FilterByHidden implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {

        return name.endsWith(".txt");
    }

}
