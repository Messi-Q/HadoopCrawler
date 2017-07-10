package com.baizhi.pc;

import java.util.List;

import com.baizhi.jdbc.SaveDetailsMongo;
import com.baizhi.jdbc.SaveMongoDAO;
import com.baizhi.jdbc.SaveMongoImpl;
import com.mongodb.DBObject;

public class RunA implements Runnable{
	public static int allCount;
	private int count=0;
	SaveMongoDAO saveMongoDAO = new SaveMongoImpl();
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		List<DBObject> findAllUrl = saveMongoDAO.findAllUrl();
		while(allCount>count){
			synchronized(this){
				count++;
			}
			System.out.println(count+"+++++++++++++++++++");
			if(allCount>count){
				String url = (String)findAllUrl.get(count).get("url");
				String type = (String)findAllUrl.get(count).get("type");
				try {
					if((UtilCra.loc).equals(type)){
						SaveImg.getHrefByNet(url);
					}
					else{
						SaveImg.getF(UtilCra.hsUrl+url);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
