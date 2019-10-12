package com.translate.translatefile;

import java.io.File;
import java.util.List;

public interface TranslateContext {
    File translateFile(File file);
    String translateSentence(String text);
    String translateParagraph(String text);
}
