package com.littlejava.model;

import java.io.*;
import java.util.ArrayList;

public class NewsFactory {

    private File newsDir;

    public NewsFactory(String dir) throws Exception {
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
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String title = reader.readLine();
                    reader.readLine(); // 跳过空行
                    String content = reader.readLine();

                    News news = new News(title,content);

                    newsList.add(news);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return newsList;
    }


}
