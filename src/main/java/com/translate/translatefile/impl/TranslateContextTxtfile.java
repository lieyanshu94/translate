package com.translate.translatefile.impl;

import com.translate.translatefile.TranslateContext;

import java.io.*;

public class TranslateContextTxtfile implements TranslateContext {
    private File trafile;
    public File translateFile(File file) {
        TranslateContext context = new TranslateContextTxtfile();
        trafile = file;
        try {
            BufferedReader br = new BufferedReader(new FileReader(trafile));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder sb = new StringBuilder();
        context.translateSentence(sb.toString());
        return null;
    }

    public String translateSentence(String text) {
        return null;
    }

    public String translateParagraph(String text) {
        return null;
    }
}
