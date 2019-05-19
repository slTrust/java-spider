package com.littlejava.model;

import java.util.HashMap;
import java.util.Map;

public class NewsWithRelated extends News{

    private HashMap<String,String> related;
    public NewsWithRelated(String title, String content) {
        super(title, content);
        related = new HashMap<>();
    }

    public void addRelated(String title,String url){
        this.related.put(title,url);
    }

    public HashMap<String,String> getRelated(){
        return this.related;
    }

    public void display(){
        super.display();
        System.out.println("|Related|");
        for (Map.Entry<String,String> entry: this.related.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
