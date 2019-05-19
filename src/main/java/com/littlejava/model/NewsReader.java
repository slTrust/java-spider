package com.littlejava.model;

import java.io.File;

// 抽象读取目录文件
/*
* 文件里 有 1.txt 按空行分割数据的
*
* 文件里有 xx.json 按json格式来存数据的
* */
public abstract class NewsReader {
    protected File file;

    public NewsReader(File file) {
        this.file = file;
    }

    public abstract News readNews();
}
