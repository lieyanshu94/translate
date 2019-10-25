package com.translate.translatefile.impl;

import com.translate.translatefile.TranslateContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TranslateContextTxtfile implements TranslateContext {
    private File trafile;
    public File translateFile(File file) {
        TranslateContext context = new TranslateContextTxtfile();
        trafile = file;

        Map<Integer , String> map = new ConcurrentHashMap<Integer, String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(trafile));
            String read = null;
            StringBuilder stringBuilder = new StringBuilder();
            Integer num = 0;
            while ((read = br.readLine()) != null) {
                byte[] bytes = read.getBytes();
                if (stringBuilder.toString().getBytes("utf-8").length + read.getBytes("utf-8").length < 200) {
                    stringBuilder.append(read+"\r\n");
                } else {

                    map.put(num,translateSentence(stringBuilder.toString()));
                    num++;
                    stringBuilder.setLength(0);
                    stringBuilder.append(read+"\r\n");
                }
            }
            map.put(num,translateSentence(stringBuilder.toString()));
            for (Map.Entry<Integer,String> entry : map.entrySet()) {
                int a = entry.getKey();
                System.out.print(entry.getValue());
            }
            StringBuilder sb  = new StringBuilder();
            for (int i = 0 ; i < map.size() ; i++) {
                sb.append(map.get(i));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        context.translateSentence(sb.toString());
        return null;
    }

    public String translateSentence(String text) {

        return text;
    }

    public String translateParagraph(String text) {
        return text;
    }
}
