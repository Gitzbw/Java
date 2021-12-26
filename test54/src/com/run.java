package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        News news2 = new News("男子突然想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        News news3 = new News("特朗普下台，拜登上台");
        ArrayList List = new ArrayList();
        List.add(news1);
        List.add(news2);
        List.add(news3);
        Collections.reverse(List);
        System.out.println(List);
        Iterator iterator = List.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            News news = (News) next;
            if(news.getTitle().length()>= 15)
            {
                String s = news.getTitle().substring(0,15);
                System.out.println(s);
            }
            else
            {
                System.out.println(news);
            }
        }

    }
}

class News
{
    private String Title;
    private String Content;

    public News(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return  Title ;
    }
}
