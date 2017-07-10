package com.baizhi.test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class TestImg {
	@Test
	public void test() throws IOException{
		HttpURLConnection httpUrl = null;
		URL url = null;
		url = new URL("http://bj.ganji.com/tel_img/?c=kt1K66kLBRxBC9oul73MvOct0fHPtQyX");
		httpUrl = (HttpURLConnection) url.openConnection();
		httpUrl.connect();
		InputStream is = httpUrl.getInputStream();
		Configuration configuration=new Configuration();
		configuration.set("fs.defaultFS", "hdfs://192.168.211.128:9000");
		FileSystem fileSystem=FileSystem.get(configuration);
		OutputStream out = fileSystem.create(new Path("/a.jpg"));
		IOUtils.copyBytes(is, out,1024);
		IOUtils.closeStream(is);
		IOUtils.closeStream(out);
	}
}
