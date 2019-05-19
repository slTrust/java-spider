package com.littlejava.model;

import com.littlejava.model.impl.JsonNewsReader;
import com.littlejava.model.impl.TextNewsReader;

import java.io.*;
import java.util.ArrayList;

public class NewsFactory2 {

    private File newsDir;

    public NewsFactory2(String dir) throws Exception {
        newsDir = new File(dir);
        if(!newsDir.exists()){
            throw new Exception("路径不存在");
        }

        if(!newsDir.isDirectory()){
            throw new Exception("输入路径不是一个合法目录！");
        }
    }


    public ArrayList<News> fetch(){
        ArrayList<News> newsList = new ArrayList<>();
        // 读取目录下文件列表
        File[] files = newsDir.listFiles();

        if(files != null){
            for (File file: files) {

                NewsReader newsReader = null;
                if( file.getName().endsWith(".txt") ){
                    newsReader = new TextNewsReader(file);
                }else if( file.getName().endsWith(".json") ){
                    newsReader = new JsonNewsReader(file);
                }

                News news = newsReader.readNews();
                newsList.add(news);
            }
        }
        return newsList;
    }


}
