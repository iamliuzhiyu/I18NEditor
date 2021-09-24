package io.github.iamliuzhiyu.I18NEditor.parster;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Json {
    private File file;
    private Charset charset;
    private Map<String, String> map;
    private ArrayList<String> arrayList;
    private String content;
    private String contentType;
    private final String MAP = "Map";
    private final String ARRAYLIST = "ArrayList";
    private final String OTHER = "Other";

    public Json(String path, Charset charset) throws IOException {
        this.charset = charset;
        this.file = new File(path);
        this.content = FileUtils.readFileToString(this.file, charset);
        if (this.content.startsWith("{")) {
            this.contentType = this.MAP;
            this.map = new HashMap();
            StringBuffer contentBuffer = new StringBuffer(content);
            contentBuffer.replace(0, 1, "{");
            contentBuffer.replace(contentBuffer.length(), 1, "{");
        }
    }
}

