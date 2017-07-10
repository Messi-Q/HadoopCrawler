package com.baizhi.pc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.baizhi.jdbc.SaveDetailsMongo;

public class SaveImg {
	//爬取图片
	public static void getHrefByNet(String url) throws Exception
	{    
		try {
			//这是get方式得到的
			Document doc = Jsoup.connect(url).get();
			String title = doc.title();

			Elements links = doc.select("span#isShowPhoneTop > img");//得到隐藏的电话号码图片标签对象
			Elements name = doc.select("span#isShowPhoneTop > em");//得到联系人标签对象
			for(Element namea:name){
				String nametext = namea.text();//得到联系人
				String linkText = links.get(0).attr("src");//得到图片路径
				//System.out.println(linkText+":"+linkHref);
				saveImg(UtilCra.gjUrl+linkText, nametext);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载失败");
		}
	}
	//房天下
	public static void getF(String url) throws Exception
	{    
		try {
			//这是get方式得到的
			Document doc = Jsoup.connect(url).get();
			String title = doc.title();

			Elements phone = doc.select(UtilCra.saveImgTag_1);//得到手机号
			Elements name = doc.select(UtilCra.saveImgTag_2);//得到联系人标签对象
			for(Element namea:name){
				String nametext = namea.text();//得到联系人姓名
				String iphone = phone.get(0).text();//得到电话号码
				//System.out.println(linkText+":"+linkHref);
				SaveDetailsMongo.save(iphone, nametext);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载失败");
		}
	}
	
	//图片保存到hdfs
	/*public static void saveToFile(String destUrl,String name) {

		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		try {
			url = new URL("http://bj.ganji.com/"+destUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			File file = new File("f:\\img\\" + loc + ".jpg");
			System.out.println(file.getAbsolutePath());
			fos = new FileOutputStream(file);
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.flush();
			Configuration configuration=new Configuration();
			configuration.set("fs.defaultFS", "hdfs://192.168.211.128:9000");
			FileSystem fileSystem=FileSystem.get(configuration);		
			OutputStream out = fileSystem.create(new Path("/"+name+","+UUID.randomUUID().toString()+".jpg"));		
			//InputStream is=new FileInputStream("C:\\Users\\Administrator\\Desktop\\文件\\2.jpg");		
			IOUtils.copyBytes(bis, out,1024);
			IOUtils.closeStream(bis);
			IOUtils.closeStream(out);
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassCastException e) {
			System.out.println("ClassCastException");
		} finally {
			try {
				bis.close();
				httpUrl.disconnect();
			} catch (IOException e) {
			} catch (NullPointerException e) {
			}
		}
	}*/
	
	public static void saveImg(String url,String name) throws Exception{
		URL url2 = new URL(url);
		URLConnection openConnection = url2.openConnection();
		InputStream inputStream = openConnection.getInputStream();
		BufferedInputStream buff= new BufferedInputStream(inputStream);
		FileOutputStream fileOutputStream = new FileOutputStream(new File(UtilCra.savePostion+name+UUID.randomUUID().toString()+".jpg"));
		byte[] by =new byte[1024];
		int i = 0;
		while((i=buff.read(by))!=-1){
			fileOutputStream.write(by, 0, i);
		}
		inputStream.close();
		fileOutputStream.close();
		buff.close();
	}
}

