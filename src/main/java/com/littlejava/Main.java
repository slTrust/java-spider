package com.littlejava;

import com.littlejava.model.News;
import com.littlejava.model.NewsFactory2;
import com.littlejava.model.NewsWithRelated;
import com.littlejava.model.Viewable;
import com.littlejava.model.impl.UrlNewsReader;
import com.littlejava.view.ListView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        // 需求 解析 https://readhub.cn/

        // 1。抽象出对象
        // 2。 设计好 对象应具有的属性和状态 / 行为
        // 3。 思考 对象之间的交互
        // 4。 开始写代码

        String resources_path = Main.class.getClassLoader().getResource("read_hub").getPath();

//        NewsFactory newsReader = new NewsFactory(resources_path);
//        ArrayList<News> newsList = newsReader.fetch();
//
//        ListView viewer = new ListView(newsList);
//        viewer.display();


//        NewsFactory2 newsReader = new NewsFactory2(resources_path);
//        ArrayList<News> newsList = newsReader.fetch();
//
//        // 类型转换
//        ArrayList<Viewable> viewables = new ArrayList<>();
//        viewables.addAll(newsList);
//        ListView viewer = new ListView(viewables);
//        viewer.display();


        NewsWithRelated news = UrlNewsReader.read("https://readhub.cn/topic/7MMx45n4vls");
        news.display();

    }
}
