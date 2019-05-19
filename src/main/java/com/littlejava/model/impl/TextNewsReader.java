package com.littlejava.model.impl;

import com.littlejava.model.News;
import com.littlejava.model.NewsReader;
import com.littlejava.model.NewsWithRelated;

import java.io.*;

public class TextNewsReader extends NewsReader {

    public TextNewsReader(File file) {
        super(file);
    }

    @Override
    public News readNews() {
        News news = null;
        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String title = reader.readLine();
            reader.readLine(); // 跳过空行
            String content = reader.readLine();
            news = new News(title,content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news;
    }
}
