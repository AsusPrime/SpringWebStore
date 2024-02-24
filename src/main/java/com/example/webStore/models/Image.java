package com.example.webStore.models;

import java.io.File;
import java.io.FileNotFoundException;

public class Image {
    private File filePath;

    public String getFilePath() {
        return filePath.toString();
    }

    public void setFilePath(String filePath, String fileName) {
        this.filePath = new File(filePath, fileName);
    }
}
