package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    HashSet<String> urlSet;
    int MAX_DEPTH=2;
    Crawler(){
        urlSet=new HashSet<>();
    }
    public void getPageTextsLinks(String url,int depth){
        if(urlSet.contains(url)){
            return;
        }
        if(depth>=MAX_DEPTH){
            return;
        }
        if(urlSet.add(url)){
            System.out.println(url);
        }
        depth++;
        try{
            Document document= Jsoup.connect(url).timeout(5000).get();
            Indexer indexer=new Indexer(document,url);
            System.out.println(document.title());
            Elements availableLinksOnPages=document.select("a[href]");

            for(Element currentLinks:availableLinksOnPages){
                getPageTextsLinks(currentLinks.attr("abs:href"),depth);
            }
        }
        catch (IOException ioException){
            ioException.getStackTrace();
        }


    }
    public static void main(String[] args) {

        Crawler crawler =new Crawler();
        crawler.getPageTextsLinks("http://www.javatpoint.com",0);
        crawler.getPageTextsLinks("https://www.geeksforgeeks.org/",0);
        crawler.getPageTextsLinks("https://leetcode.com/",0);
        crawler.getPageTextsLinks("https://www.w3schools.com/",0);
    }
}