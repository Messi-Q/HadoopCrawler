package com.baizhi.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class TestMongo {
	private static Mongo mongo;
	private static DB db;
	private static DBCollection dbCollection;
	public static void co(){
		// TODO Auto-generated method stub
		try {
			mongo = new Mongo("127.0.0.1",27017);
			db = mongo.getDB("hadoop");
			dbCollection=db.getCollection("add");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		}
	}
	@Test
	public void test(){
		co();
		DBObject dbObject = new BasicDBObject();
		dbObject.put("_id", "59322978407c5f8b956a67a3");
		DBObject set1 = new BasicDBObject();
		set1.put("username","aaaaasdaa");
		DBObject set2 = new BasicDBObject();
		set2.put("$set", set1);
		dbCollection.update(dbObject, set2, false, true);
	}
	@Test
	public void tset1(){
		co();
		DBObject set1 = new BasicDBObject();
		set1.put("username","aaaaa");
		DBObject findOne = dbCollection.findOne(set1);
		Map map = findOne.toMap();
		System.out.println(map.toString());
		
	}
	@Test
	public void test3() throws Exception{
		Document doc = Jsoup.connect("http://zu.fang.com/").get();
		String title = doc.title();

		Elements links = doc.select("p[class=title] > a");//得到隐藏的电话号码图片标签对象
		Elements name = doc.select("p[class=gray6 mt20] > a > span");//得到联系人标签对象
		for(Element namea:name){
			String nametext = namea.text();//得到联系人
			String linkText = links.get(0).text();//得到图片路径
			System.out.println(nametext+":"+linkText);
		}
	}
}