package com.translate.win;

import com.translate.fileplant.FileFactory;

import java.io.File;

public class Mainwin {
    public static void main(String[] args) {
        String filepath = "D:\\BaiduNetdiskDownload\\新建文本文档.txt";
        File file = new File(filepath);
        FileFactory factory = FileFactory.getInstance();
        if (factory.canTranslate(file)) {
            File trafile = factory.translateFile();
            System.out.println("A");
        }
    }
}
