package com.littlejava.model.impl;

import com.littlejava.model.NewsWithRelated;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

// 从 Url 中读取news
public class UrlNewsReader {
    public static NewsWithRelated read(String url) throws IOException {
        // jsop 读取和解析 页面
        Document doc = Jsoup.connect(url).get();

        Elements titleElements = doc.select("title"); // 返回的是元素数组
        String title = titleElements.first().text(); // 第一个元素的 text

//        System.out.println(titleElements.size());

        Elements contentElements = doc.select(".summary___3oqrM");
        String content = contentElements.first().text();


        NewsWithRelated news = new NewsWithRelated(title,content);


        Elements relatedElements = doc.select(".row___3h219");

        for (Element e: relatedElements) {
            String relatedTitle = e.select(".url___3iQHY").first().text();
            String relatedUrl = e.select(".url___3iQHY").first().attr("href");
            System.out.println(relatedTitle);
            System.out.println(relatedUrl);

            news.addRelated(relatedTitle,relatedUrl);
        }

        /*
        * select 语法
        * 1. 标签名 "title" "p"
        * 2. class ".main_box"  选择器 类名
        * 3. id "#xxx" id选择器
        * 4. 属性 [name="xxx"]
        * */

        return news;

    }
}
