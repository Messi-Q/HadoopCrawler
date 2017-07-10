package com.baizhi.pc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.baizhi.jdbc.SaveMongoDAO;
import com.baizhi.jdbc.SaveMongoImpl;

public class Crawler {
	private static SaveMongoDAO  saveMongoDAO = new SaveMongoImpl();
	/**
	 * 保存信息到mongoDB
	 * @param url
	 */
	public static void getURl(String url,String tag1,String tag2,String type)
    {    
         try {
            //这是get方式得到的
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select(tag1);//得到帖子的<a>标签
            Elements loc = doc.select(tag2);//得到地址的标签
            int i = 0;
            for(Element link:links){
            	String location = loc.get(i).text();//得到地址
                String linkText = link.attr("href");//得到帖子的url
                //System.out.println(linkText+":"+linkHref);
                saveMongoDAO.save(location, linkText,type);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("加载失败");
        }
    }
}
