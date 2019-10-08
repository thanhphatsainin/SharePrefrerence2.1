package com.example.shareprefrerence2;

public class Keep {
    private String header;
    private String content;
    private int check;

    public Keep(String header, String content, int check) {
        this.header = header;
        this.content = content;
        this.check = check;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
