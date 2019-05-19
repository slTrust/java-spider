package com.littlejava.model;

public class News  implements Viewable{
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void display(){
        System.out.println("|Title| " + this.getTitle());
        System.out.println("|Content| " + this.getContent());
    }
}
