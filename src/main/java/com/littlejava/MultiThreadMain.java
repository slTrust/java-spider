package com.littlejava;


import com.littlejava.activity.SpiderThread;
import com.littlejava.model.NewsWithRelated;
import com.littlejava.model.SearchSate;
import com.littlejava.model.impl.UrlNewsReader;
import com.littlejava.view.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiThreadMain {

    // 本地存储新闻内容，如何在终端显示

    // 1. 抽象出 对象
    // 2. 设计 对象应该具有的属性，状态和行为
    // 3. 思考 对象之间交互
    // 4. 开始写代码

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        // 广度优先搜索
        SearchSate searchSate = new SearchSate(10);

        String basetUrl = "https://readhub.cn/topic/";
        String startUrl = "https://readhub.cn/topic/7MMx45n4vls";
        NewsWithRelated startNews = UrlNewsReader.read(startUrl);

        searchSate.visit(startNews);
        while (searchSate.hasTarget()) {
            NewsWithRelated current = searchSate.poll();
            searchSate.addResult(current);
            List<SpiderThread> spiders = new ArrayList<SpiderThread>();
            System.out.println(current.getRelated());
            for (Map.Entry<String, String> entry : current.getRelated().entrySet()) {
                String url = entry.getValue();
                spiders.add(new SpiderThread(searchSate, basetUrl + url));
            }

            //等待所有线程停止
            for (SpiderThread spider : spiders) {
                spider.join();
            }
        }
        long endTime=System.currentTimeMillis();

        new ListView(searchSate.getResults()).display();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
