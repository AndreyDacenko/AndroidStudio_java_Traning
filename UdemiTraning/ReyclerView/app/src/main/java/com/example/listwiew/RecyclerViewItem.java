package com.example.listwiew;

public class RecyclerViewItem {

    private int imageRes;
    private String text1;
    private String text2;

    public RecyclerViewItem(int imageRes, String text1, String text2) {
        this.imageRes = imageRes;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

}
