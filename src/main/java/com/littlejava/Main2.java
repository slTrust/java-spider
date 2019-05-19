package com.littlejava;

import com.littlejava.model.NewsWithRelated;
import com.littlejava.model.Viewable;
import com.littlejava.model.impl.UrlNewsReader;

import java.io.IOException;
import java.util.*;

public class Main2 {
    public static final int maximumURL = 10;
    public static void main(String[] args) throws IOException {

        read2();

    }

    /**
     *  从一个url  读取 ，然后 读取它下面的相关链接
     * @throws IOException
     */
    public static void read1() throws IOException {
        NewsWithRelated news = UrlNewsReader.read("https://readhub.cn/topic/7MMx45n4vls");
        news.display();
        for(Map.Entry<String,String> entry: news.getRelated().entrySet()){
            String url = entry.getValue();
            System.out.println("------------");
            System.out.println(url);
            NewsWithRelated next = UrlNewsReader.read("https://readhub.cn/topic/" + url);
            next.display();
        }
    }


    /**
     *  广度优先搜索
     * @throws IOException
     */
    public static void read2() throws IOException {


        Queue<NewsWithRelated> newsQueue = new LinkedList<>();

        String basetUrl = "https://readhub.cn/topic/";

        String startUrl = basetUrl + "7MMx45n4vls";

        // 起点
        NewsWithRelated startNews = UrlNewsReader.read(startUrl);
        startNews.display();


        int count = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        newsQueue.add(startNews);


        // 存储访问过的内容
        ArrayList<Viewable> results = new ArrayList<>();



        while(!newsQueue.isEmpty() && count <= maximumURL){
            System.out.println("-------广度优先---------------");
            // 从队列里取
            NewsWithRelated current = newsQueue.poll();
            results.add(current);
            count += 1;
            current.display();
            for(Map.Entry<String,String> entry: current.getRelated().entrySet()){

                String url = entry.getValue();
                System.out.println("------------");
                System.out.println(url);
                NewsWithRelated next = UrlNewsReader.read(basetUrl + url);
                if( !visited.contains(url)){
                    newsQueue.add(next);
                    visited.add(url);
                }
            }
        }


        /**
         * 扩展：
         * 1。 实现去重复
         * 2。 存到本地
         */
    }
}
