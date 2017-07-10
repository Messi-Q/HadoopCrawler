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
	 * ������Ϣ��mongoDB
	 * @param url
	 */
	public static void getURl(String url,String tag1,String tag2,String type)
    {    
         try {
            //����get��ʽ�õ���
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select(tag1);//�õ����ӵ�<a>��ǩ
            Elements loc = doc.select(tag2);//�õ���ַ�ı�ǩ
            int i = 0;
            for(Element link:links){
            	String location = loc.get(i).text();//�õ���ַ
                String linkText = link.attr("href");//�õ����ӵ�url
                //System.out.println(linkText+":"+linkHref);
                saveMongoDAO.save(location, linkText,type);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
    }
}
