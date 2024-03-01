package com.example.webStore.models;

import org.springframework.data.annotation.Id;

public class Image {
    @Id
    private long id;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath, String fileName) {
        this.filePath = filePath+fileName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
