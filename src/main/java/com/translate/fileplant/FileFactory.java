package com.translate.fileplant;

import java.io.File;

public class FileFactory {
    private final String[] prifix = {"DOX","DOXC","PDF","TXT"};
    private static FileFactory fileFactory = new FileFactory();
    private FileFactory(){};
    public static FileFactory getInstance(){
        return fileFactory;
    }
    private File translated;
    private String traprifix;
    public boolean canTranslate(File file){
        if (file.exists()){
            String filename = file.getName();
            String s = filename.substring(filename.lastIndexOf(".")+1);
            if (s != null) {
                String postfix = s.toUpperCase();
                for (int i = 0 ; i<prifix.length+1 ; i++) {
                    if (i == postfix.length()) {
                        return false;
                    }
                    if(prifix[i].equals(postfix)){
                        translated = file;
                        traprifix = postfix;
                        return true;
                    }
                }

            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }
    private void translateDoc(){
        System.out.println("doc:");
    }
    private void translateDocx(){
        System.out.println("docx:");
    }
    private void translatePdf(){
        System.out.println("Pdf:");
    }
    private void translateTxt(){
        System.out.println("txt:");
    }

    public File translateFile() {
        if("DOC".equals(prifix)){
            fileFactory.translateDoc();
        } else if ("DOCX".equals(prifix)) {
            fileFactory.translateDocx();
        } else if ("PDF".equals(prifix)) {
            fileFactory.translatePdf();
        } else if ("TXT".equals(prifix)) {
            fileFactory.translateTxt();
        }
        return translated;
    }
}
